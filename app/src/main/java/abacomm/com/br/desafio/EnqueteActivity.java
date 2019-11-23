package abacomm.com.br.desafio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EnqueteActivity extends AppCompatActivity {

    public static final String NOME_DA_CIDADE = "cidade";

    private TextView campo_cidade;
    private String cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquete);

        cidade = getIntent().getStringExtra(NOME_DA_CIDADE);

        campo_cidade = findViewById(R.id.bla);
        campo_cidade.setText(cidade);
    }

}
