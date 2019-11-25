package abacomm.com.br.desafio;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RespostasAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private RespostasHolder meuHolder;

    private ArrayList<String> respostas;
    private int numero;
    private boolean clicavel = true;

    public RespostasAdapter(Activity activity, ArrayList<String> respostas, int numero) {
        this.activity = activity;
        this.respostas = respostas;
        this.numero = numero;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = activity.getLayoutInflater().inflate(R.layout.item_enquete, parent, false);
        return new RespostasHolder(layout, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int posicao) {
        meuHolder = (RespostasHolder) holder;
        meuHolder.popula(respostas.get(posicao));
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return respostas.size();
    }


    public int getNumero() { return numero; }

    public boolean ehClicavel() {
        return clicavel;
    }

    public void setClicavel(boolean clicavel) {
        this.clicavel = clicavel;
    }

}