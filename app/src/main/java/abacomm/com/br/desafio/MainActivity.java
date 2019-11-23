package abacomm.com.br.desafio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        gerenciador = new GerenciadorDePermissao(this);

        botaoLogin.setOnClickListener(view -> {
            if (gerenciador.temPermissao()) {
                new Localizador(this).configuraServico();
            } else {
                gerenciador.solicitaPermissao();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean temPermissao = gerenciador.estaAutorizado(requestCode, grantResults);

        if (temPermissao) {
            new Localizador(this).configuraServico();
        } else {
            mostraToast("Permissão de GPS necessária.");
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
}