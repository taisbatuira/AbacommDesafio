package abacomm.com.br.desafio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EnqueteActivity extends AppCompatActivity {

    private TextView bla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquete);

        bla = findViewById(R.id.bla);
    }

}
