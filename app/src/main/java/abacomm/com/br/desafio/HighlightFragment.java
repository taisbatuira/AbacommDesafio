package abacomm.com.br.desafio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HighlightFragment extends Fragment {

        private static final String TITULO = "TITULO";

        public static HighlightFragment comTituloESubtitulo(String titulo) {
            Bundle bundle = new Bundle();
            bundle.putString(TITULO, titulo);

            HighlightFragment fragment = new HighlightFragment();
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Bus.register(this);
        }

        @Override
        public void onDetach() {
            super.onDetach();
            //Bus.unregister(this);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_enquete, container, false);

            TextView titulo = layout.findViewById(R.id.fragment_welcome_titulo);

            Bundle bundle = getArguments();

            titulo.setText(bundle.getString(TITULO));

            return layout;
        }
    }
