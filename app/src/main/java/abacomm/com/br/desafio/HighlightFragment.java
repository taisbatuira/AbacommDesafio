package abacomm.com.br.desafio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HighlightFragment extends Fragment {

        private static final String TITULO = "TITULO";
        private static final String RESPOSTAS = "RESPOSTAS";

        public static HighlightFragment comPerguntaERespostas(String pergunta, String[] respostas) {
            Bundle bundle = new Bundle();
            bundle.putString(TITULO, pergunta);
            bundle.putStringArray(RESPOSTAS, respostas);

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

            TextView titulo = layout.findViewById(R.id.fragment_enquete_pergunta);
            ListView lista_de_respostas = layout.findViewById(R.id.fragment_enquete_respostas);

            Bundle bundle = getArguments();

            titulo.setText(bundle.getString(TITULO));
            String[] respostas = bundle.getStringArray(RESPOSTAS);

            String[] dados = respostas;
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dados);
            lista_de_respostas.setAdapter(adapter);

            return layout;
        }
    }
