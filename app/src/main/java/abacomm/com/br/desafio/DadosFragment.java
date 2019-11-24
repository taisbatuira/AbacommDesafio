package abacomm.com.br.desafio;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class DadosFragment {

    private final AppCompatActivity activity;

    public DadosFragment(AppCompatActivity activity) {
        this.activity = activity;
    }

    public String pergunta (String pergunta, String cidade) {
        return String.format(getResource(pergunta), cidade);
    }

    public ArrayList<String> respostas(String[] lista){
        ArrayList<String> respostas = new ArrayList<>();
        for (String item : lista) {
            String nome = "resposta"+item;
            respostas.add(getResource(nome));
        }
        return respostas;
    }

    private String getResource(String string) {
        String packageName = activity.getPackageName();
        int resId = activity.getResources().getIdentifier(string, "string", packageName);
        return activity.getString(resId);
    }
}
