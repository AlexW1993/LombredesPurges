package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.AutreAventure;


public class RécupérerAventure {
    private SourceDeDonnées _source;

    public RécupérerAventure(SourceDeDonnées _source) {
        this._source = _source;
    }

    public AutreAventure[] récupérer(){
        return _source.récupérer();
    }
}
