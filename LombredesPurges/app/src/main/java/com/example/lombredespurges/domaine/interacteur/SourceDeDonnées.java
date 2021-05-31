package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AventureTéléchargeable;

import java.util.ArrayList;


public interface SourceDeDonnées {
    public AutreAventure[] récupérerListeServeur();

    public String récupérerAventureServeur();

    public ArrayList<AutreAventure> chercherTousAventures();

    public ArrayList<AventureTéléchargeable> chercherAventuresJson();

    public void ajouterAventure(String title, String url);

    public void ajoterAventureJson(String title, String json);

    public void reset();
}
