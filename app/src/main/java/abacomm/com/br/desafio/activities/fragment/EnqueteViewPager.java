package abacomm.com.br.desafio.activities.fragment;

import java.util.ArrayList;
import java.util.List;

import abacomm.com.br.desafio.DadosFormatados;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class EnqueteViewPager extends FragmentStatePagerAdapter {

        private AppCompatActivity activity;
        private DadosFormatados dados;
        private String cidade;

        private List<HighlightFragment> fragments = new ArrayList<>();

        public EnqueteViewPager(AppCompatActivity activity, String cidade) {
            super(activity.getSupportFragmentManager());

            this.activity = activity;
            this.cidade = cidade;
            this.dados = new DadosFormatados(activity);

            populaPager(1, "pergunta1", new String[]{"1_1", "1_2", "1_3"});
            populaPager(2, "pergunta2", new String[]{"2_1", "2_2", "2_3"});
            populaPager(3, "pergunta3", new String[]{"3_1", "3_2", "3_3"});
            populaPager(4, "pergunta4", new String[]{"4_1", "4_2", "4_3"});
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        private void populaPager(int numero, String pergunta, String[] lista) {
            this.fragments.add(
                    HighlightFragment.comPerguntaERespostas(numero,
                                                            dados.pergunta(pergunta, cidade),
                                                            dados.respostas(lista)));
        }
}
