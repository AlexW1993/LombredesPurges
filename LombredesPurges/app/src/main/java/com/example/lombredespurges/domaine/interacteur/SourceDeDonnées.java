package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.AutreAventure;
import com.example.lombredespurges.domaine.entité.Chapitre;

import java.util.ArrayList;


public interface SourceDeDonnées {
    public AutreAventure[] récupérerListeServeur( );

    public ArrayList<AutreAventure> chercherTousAventures();
    public void ajouterAventure(String title, String url);
    public void reset();
}
