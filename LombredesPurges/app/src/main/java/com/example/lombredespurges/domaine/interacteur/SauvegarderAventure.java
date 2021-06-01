package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;

public class SauvegarderAventure {

    /**
     * Declaration des Attributs
     */
    private SourceDeDonnées _source;

    /**
     * Constructeur de SauvegarderAventure
     */
    public SauvegarderAventure(SourceDeDonnées source) {
        this._source = source;
    }

    /**
     * La méthode permet sauvegarder l'aventure dans la BD.
     *
     * @param (aventure,aventureJson), le nom de l'aventure et l'aveture complète en format Json.
     */
    public void SauvegarderAventureBD(AutreAventure aventure, String aventureJson) {
        //_source.reset();
        _source.ajouterAventure(aventure.getTitle(), aventure.getUrl());
        _source.ajoterAventureJson(aventure.getTitle(), aventureJson);
    }
}