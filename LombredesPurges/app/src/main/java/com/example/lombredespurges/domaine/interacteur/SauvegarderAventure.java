package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;

public class SauvegarderAventure {

    private SourceDeDonnées _source;

    public SauvegarderAventure(SourceDeDonnées source) {
        this._source = source;
    }

    public void SauvegarderAventureBD(AutreAventure aventure, String aventureJson){
        //_source.reset();
        _source.ajouterAventure(aventure.getTitle(), aventure.getUrl());
        _source.ajoterAventureJson(aventure.getTitle(),aventureJson);
    }
}