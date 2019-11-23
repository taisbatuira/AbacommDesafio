package abacomm.com.br.desafio;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class EnqueteActivity extends AppCompatActivity {

    public static final String NOME_DA_CIDADE = "cidade";

    private int paginaAtual = 0;
    private TextView campo_cidade;
    private String cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquete);

        cidade = getIntent().getStringExtra(NOME_DA_CIDADE);

        campo_cidade = findViewById(R.id.bla);
        campo_cidade.setText(cidade);

        androidx.viewpager.widget.ViewPager pager = findViewById(R.id.welcome_container);
        EnqueteViewPager adapter = new EnqueteViewPager(this);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.welcome_dots);
        tabLayout.setupWithViewPager(pager, false);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                paginaAtual = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        pager.setOnTouchListener((v, event) -> true);
    }
}
