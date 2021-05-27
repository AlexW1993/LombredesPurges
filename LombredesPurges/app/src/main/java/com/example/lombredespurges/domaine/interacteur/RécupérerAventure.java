package com.example.lombredespurges.domaine.interacteur;


import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AventureTéléchargeable;

import java.util.ArrayList;


public class RécupérerAventure {
    private SourceDeDonnées _source;

    public RécupérerAventure(SourceDeDonnées _source) {
        this._source = _source;
    }

    public ArrayList<AutreAventure> récupérerListeAventureServeur(){
        ArrayList<AutreAventure> listeAventures = new ArrayList<>();
        AutreAventure [] tab = _source.récupérerListeServeur();
        for (int i = 0; i < tab.length ; i++) {
            listeAventures.add(tab[i]);
        }
        return listeAventures;
    }

    public String récupérerAventureServeur(){
        return _source.récupérerAventureServeur();
    }

    public ArrayList<AutreAventure> récupérerAventuresBD(){
        return _source.chercherTousAventures();
    }

    public ArrayList<AventureTéléchargeable> récupérerAventuresTéléchargeablesBD(){
        return _source.chercherAventuresJson();
    }
}
