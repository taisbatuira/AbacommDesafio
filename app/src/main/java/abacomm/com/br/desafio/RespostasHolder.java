package abacomm.com.br.desafio;

import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

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
            System.out.println(adapter.getNumero());
            EventBus.getDefault().post(new EventoPerguntaRespondida(adapter.getNumero()));
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
