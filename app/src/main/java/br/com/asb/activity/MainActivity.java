package br.com.asb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.asb.R;

public class MainActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();

    }

    void intiView() {


    }

    public void cadastrarAnamnase(View view) {

        startActivity(new Intent(MainActivity.this, TelaCadastroInicialActivity.class));
    }

    public void visualizarListaProfissionaisEntrevistados(View view) {

        startActivity(new Intent(MainActivity.this, ListarProfissionaisEntrevistadosActivity.class));

    }
    public void processarBakcupDataBase(View view) {

        startActivity(new Intent(MainActivity.this, BackupSQLActivity.class));

    }


}
