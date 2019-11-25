package abacomm.com.br.desafio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HighlightFragment extends Fragment {

    private static final String NUMERO = "NUMERO";
    private static final String PERGUNTA = "PERGUNTA";
    private static final String RESPOSTAS = "RESPOSTAS";
    private static HighlightFragment fragment;

    RecyclerView respostasRecyclerView;
    public RespostasAdapter adapter;

    public static HighlightFragment comPerguntaERespostas(int numero, String pergunta, ArrayList<String> respostas) {
        Bundle bundle = new Bundle();
        bundle.putInt(NUMERO, numero);
        bundle.putString(PERGUNTA, pergunta);
        bundle.putStringArrayList(RESPOSTAS, respostas);
        fragment = new HighlightFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_enquete, container, false);

        Bundle bundle = getArguments();
        int numero = bundle.getInt(NUMERO);

        TextView campoNumero = layout.findViewById(R.id.fragment_enquete_numero);
        campoNumero.setText(String.valueOf(numero));

        TextView campoPergunta = layout.findViewById(R.id.fragment_enquete_pergunta);
        campoPergunta.setText(bundle.getString(PERGUNTA));

        ArrayList<String> dados = bundle.getStringArrayList(RESPOSTAS);

        respostasRecyclerView = layout.findViewById(R.id.fragment_enquete_respostas);
        adapter = new RespostasAdapter(getActivity(), dados, numero);
        respostasRecyclerView.setAdapter(adapter);

        LinearLayoutManager vertical = new LinearLayoutManager(getContext());
        vertical.setOrientation(RecyclerView.VERTICAL);
        respostasRecyclerView.setLayoutManager(vertical);

        return layout;
    }
}
