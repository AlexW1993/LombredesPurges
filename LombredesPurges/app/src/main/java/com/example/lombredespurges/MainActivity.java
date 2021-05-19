package com.example.lombredespurges;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.lombredespurges.modele.Modèle;
import com.example.lombredespurges.source_de_données.SourceDeDonnéesHTTP;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Modèle modèle =Modèle.getInstance();
        modèle.set_source( new SourceDeDonnéesHTTP( this, "https://hugocodestar.github.io/site/adventurelist.json"));
        setContentView(R.layout.activity_main);

    }
}