package abacomm.com.br.desafio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    protected Button botaoLogin;
    private String usuario;
    private String senha;
    private AppCompatEditText campoUsuario;
    private AppCompatEditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoLogin = findViewById(R.id.login_button);

        campoUsuario = findViewById(R.id.login_usuario);
        campoSenha = findViewById(R.id.login_senha);

        TextView esqueceuSenha = findViewById(R.id.login_esqueceu_a_senha);
        TextView registrar = findViewById(R.id.login_registrar);

        botaoLogin.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, EnqueteActivity.class);
                MainActivity.this.startActivity(intent);
        });

        esqueceuSenha.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Senha: 1234", Toast.LENGTH_SHORT).show();
        });

        registrar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Acesse nosso site!", Toast.LENGTH_SHORT).show();
        });
    }
}
