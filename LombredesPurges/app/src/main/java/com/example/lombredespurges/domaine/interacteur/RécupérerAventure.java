package com.example.lombredespurges.domaine.interacteur;


import com.example.lombredespurges.domaine.entité.AutreAventure;

import java.util.ArrayList;


public class RécupérerAventure {
    private SourceDeDonnées _source;

    public RécupérerAventure(SourceDeDonnées _source) {
        this._source = _source;
    }

    public ArrayList<AutreAventure> récupérerAventureServeur(){
        ArrayList<AutreAventure> listeAventures = new ArrayList<>();
        AutreAventure [] tab = _source.récupérerServeur();
        for (int i = 0; i < tab.length ; i++) {
            listeAventures.add(tab[i]);
        }
        return listeAventures;
    }

    public ArrayList<AutreAventure> récupérerAventuresBD(){
        return _source.chercherTousAventures();
    }
}
