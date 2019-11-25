package abacomm.com.br.desafio.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import abacomm.com.br.desafio.GerenciadorDePermissao;
import abacomm.com.br.desafio.Localizador;
import abacomm.com.br.desafio.R;
import abacomm.com.br.desafio.ValidaLoginESenha;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

public class MainActivity extends AppCompatActivity {

    protected Button botaoLogin;
    private String usuario;
    private String senha;
    private AppCompatEditText campoUsuario;
    private AppCompatEditText campoSenha;
    private GerenciadorDePermissao gerenciador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoLogin = findViewById(R.id.login_button);

        campoUsuario = findViewById(R.id.login_usuario);
        campoSenha = findViewById(R.id.login_senha);

        TextView esqueceuSenha = findViewById(R.id.login_esqueceu_a_senha);
        TextView registrar = findViewById(R.id.login_registrar);

        esqueceuSenha.setOnClickListener(view -> {
            mostraToast("Senha 1234");
        });

        registrar.setOnClickListener(view -> {
            mostraToast("Acesse nosso site!!!");
        });

        habilitaBotaoLogin();
    }

    private void habilitaBotaoLogin() {

        botaoLogin.setOnClickListener(view -> {
            usuario = campoUsuario.getText().toString();
            senha = campoSenha.getText().toString();

            boolean loginValido = new ValidaLoginESenha(usuario, senha).temPermissao();

            if (loginValido) {
                localizaOuSolicitaPermissaoDeGps();
            } else {
                mostraAlert();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean temPermissaoDeGps = gerenciador.estaAutorizado(requestCode, grantResults);

        if (temPermissaoDeGps) {
            new Localizador(this).configuraServico();
        } else {
            mostraToast("Permissão de GPS é necessária.");
        }
    }

    private void localizaOuSolicitaPermissaoDeGps() {
        gerenciador = new GerenciadorDePermissao(this);
        if (gerenciador.temPermissao()) {
            new Localizador(this).configuraServico();
        } else {
            gerenciador.solicitaPermissao();
        }
    }

    public void abreEnquete(String cidade) {
        Intent intent = new Intent(MainActivity.this, EnqueteActivity.class);
        intent.putExtra(EnqueteActivity.NOME_DA_CIDADE, cidade);
        MainActivity.this.startActivity(intent);
    }

    private void mostraToast(String mensagem) {
        Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
    }

    private void mostraAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login ou Senha inválido!");
        builder.setMessage("Tente novamente!!");
        builder.setPositiveButton("Ok", (dialog, id) -> { });
        builder.create();
        builder.show();
    }
}