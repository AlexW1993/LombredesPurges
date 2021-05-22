package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.AutreAventure;

import java.util.ArrayList;


public interface SourceDeDonnées {
    public AutreAventure[] récupérerServeur( );
    public ArrayList<AutreAventure> chercherTousAventures();
    public void ajouterAventure(String title, String url);
    public void reset();
}
