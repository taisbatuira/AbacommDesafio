package abacomm.com.br.desafio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HighlightFragment extends Fragment {

        private static final String PERGUNTA = "PERGUNTA";
        private static final String RESPOSTAS = "RESPOSTAS";

        public static HighlightFragment comPerguntaERespostas(String pergunta, ArrayList<String> respostas) {
            Bundle bundle = new Bundle();
            bundle.putString(PERGUNTA, pergunta);
            bundle.putStringArrayList(RESPOSTAS, respostas);
            HighlightFragment fragment = new HighlightFragment();
            fragment.setArguments(bundle);

            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_enquete, container, false);

            TextView titulo = layout.findViewById(R.id.fragment_enquete_pergunta);
            ListView lista_de_respostas = layout.findViewById(R.id.fragment_enquete_respostas);

            Bundle bundle = getArguments();

            titulo.setText(bundle.getString(PERGUNTA));
            ArrayList<String> respostas = bundle.getStringArrayList(RESPOSTAS);

            ArrayList<String> dados = respostas;
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dados);
            lista_de_respostas.setAdapter(adapter);

            return layout;
        }
    }
