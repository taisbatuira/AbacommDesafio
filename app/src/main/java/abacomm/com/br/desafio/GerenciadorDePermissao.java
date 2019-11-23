package abacomm.com.br.desafio;

import android.Manifest;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

;


public class GerenciadorDePermissao {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private AppCompatActivity activity;
    private int permissaoDeGps;

    public GerenciadorDePermissao(AppCompatActivity activity) {
        this.activity = activity;
    }

    public boolean temPermissao() {
        permissaoDeGps = activity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
        return permissaoDeGps == PackageManager.PERMISSION_GRANTED;
    }

    public void solicitaPermissao() {
        activity.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    REQUEST_CODE_ASK_PERMISSIONS);
    }

    public boolean estaAutorizado(int requestCode, @NonNull int[] grantResults) {
        return requestCode == REQUEST_CODE_ASK_PERMISSIONS && grantResults[0] == PackageManager.PERMISSION_GRANTED;
    }

}
