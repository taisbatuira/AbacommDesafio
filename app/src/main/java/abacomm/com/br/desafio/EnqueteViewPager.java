package abacomm.com.br.desafio;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

;

public class EnqueteViewPager extends FragmentStatePagerAdapter {

        private final List<HighlightFragment> fragments = new ArrayList<>();

        public EnqueteViewPager(AppCompatActivity activity) {
            super(activity.getSupportFragmentManager());

            String pergunta1 = String.format(activity.getString(R.string.pergunta1), "São Paulo");
            String resposta1 = activity.getString(R.string.resposta1_1);
            String resposta2 = activity.getString(R.string.resposta1_2);
            String resposta3 = activity.getString(R.string.resposta1_3);
            this.fragments.add(
                    HighlightFragment.comPerguntaERespostas(pergunta1,
                                                            new String[] {resposta1, resposta2, resposta3}));

            String pergunta2 = String.format(activity.getString(R.string.pergunta2), "São Paulo");
            String resposta4 = activity.getString(R.string.resposta2_1);
            String resposta5 = activity.getString(R.string.resposta2_2);
            String resposta6 = activity.getString(R.string.resposta2_3);

            this.fragments.add(
                    HighlightFragment.comPerguntaERespostas(pergunta2,
                                                            new String[] {resposta4,  resposta5, resposta6}));
//            this.fragments.add(HighlightFragment.comTituloESubtitulo(activity.getString(R.string.fragment_welcome_titulo_2), activity.getString(R.string.fragment_welcome_subtitulo_2)));
//            this.fragments.add(HighlightFragment.comTituloESubtitulo(activity.getString(R.string.fragment_welcome_titulo_3), activity.getString(R.string.fragment_welcome_subtitulo_3)));
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

}
