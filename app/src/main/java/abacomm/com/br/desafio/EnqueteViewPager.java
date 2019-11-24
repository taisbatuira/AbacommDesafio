package abacomm.com.br.desafio;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class EnqueteViewPager extends FragmentStatePagerAdapter {

        private AppCompatActivity activity;
        private DadosFragment dados;
        private String cidade;

        private List<HighlightFragment> fragments = new ArrayList<>();

        public EnqueteViewPager(AppCompatActivity activity, String cidade) {
            super(activity.getSupportFragmentManager());

            this.activity = activity;
            this.cidade = cidade;
            this.dados = new DadosFragment(activity);

            populaPager("pergunta1", new String[]{"1_1", "1_2", "1_3"});
            populaPager("pergunta2", new String[]{"2_1", "2_2", "2_3"});
            populaPager("pergunta3", new String[]{"3_1", "3_2", "3_3"});
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

        private void populaPager(String pergunta, String[] lista) {
            this.fragments.add(
                    HighlightFragment.comPerguntaERespostas(dados.pergunta(pergunta, cidade),
                                                            dados.respostas(lista)));
        }
}
