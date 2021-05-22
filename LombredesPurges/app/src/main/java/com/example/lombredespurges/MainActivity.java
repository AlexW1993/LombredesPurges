package com.example.lombredespurges;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lombredespurges.source_de_données.BD.SourceDeDonnéesBDHelper;
import com.example.lombredespurges.modele.Modèle;
import com.example.lombredespurges.source_de_données.SourceDeDonnéesHTTP;

public class MainActivity extends AppCompatActivity {

    SourceDeDonnéesBDHelper bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Modèle modèle =Modèle.getInstance();
        modèle.set_source( new SourceDeDonnéesHTTP( this, "https://hugocodestar.github.io/site/adventurelist.json"));
        modèle.ajouterContexte(this);
        bdHelper = new SourceDeDonnéesBDHelper(this);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onDestroy() {
        bdHelper.close();
        super.onDestroy();
    }
}