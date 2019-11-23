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

            this.fragments.add(HighlightFragment.comTituloESubtitulo("funcionou esse 1"));
            this.fragments.add(HighlightFragment.comTituloESubtitulo("funcionou esse2 outro"));
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
