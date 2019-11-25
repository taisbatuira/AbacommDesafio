package abacomm.com.br.desafio.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Objects;

import abacomm.com.br.desafio.activities.fragment.EnqueteViewPager;
import abacomm.com.br.desafio.Evento.EventoPerguntaRespondida;
import abacomm.com.br.desafio.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class EnqueteActivity extends AppCompatActivity {

    public static final String NOME_DA_CIDADE = "cidade";
    private static ArrayList<Integer> respostas = new ArrayList<>();

    private int paginaAtual = 0;
    private String cidade;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquete);

        cidade = getIntent().getStringExtra(NOME_DA_CIDADE);

        getToolbar();
        getPagerRespostas();
    }

    private void getToolbar() {
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        TextView mTitle =  myToolbar.findViewById(R.id.toolbar_titulo);
        mTitle.setText("Cidade: " + cidade);
        ActionBar actionBar = Objects.requireNonNull(getSupportActionBar());
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void getPagerRespostas() {
        pager = findViewById(R.id.welcome_container);
        EnqueteViewPager adapter = new EnqueteViewPager(this, cidade);
        pager.setOffscreenPageLimit(adapter.getCount());
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

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(0, 0);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Subscribe
    public void perguntaRespondida(EventoPerguntaRespondida evento) {
        respostas.add(evento.numero);

        if (respostas.size() == 4) {
            mostraAlert();
        }
    }

    private void mostraAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fim da Pesquisa!");
        builder.setMessage("Muito obrigada pelas suas respostas!!");
        builder.setPositiveButton("Finalizar enquete", (dialog, id) -> {
            respostas.clear();
            finish();
        });
        builder.create();
        builder.show();
    }
}
