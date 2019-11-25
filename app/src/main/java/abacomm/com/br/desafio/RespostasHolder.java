package abacomm.com.br.desafio;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RespostasHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    RespostasAdapter adapter;
    TextView campo_resposta;
    View itemView;

    public RespostasHolder(View view, RespostasAdapter adapter) {
        super(view);
        itemView = view.findViewById(R.id.item_resposta_view);
        campo_resposta = view.findViewById(R.id.item_resposta_texto);
        this.adapter = adapter;

        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (adapter.ehClicavel() == true) {
            customItem(itemView, campo_resposta);
            adapter.setClicavel(false);
        }
    }

    public void popula(String resposta){
        campo_resposta.setText(resposta);
    }

    public void customItem(View view, TextView textView) {
        view.setBackgroundColor(0xffff8000);
        textView.setTextColor(0xffffffff);
    }
}
