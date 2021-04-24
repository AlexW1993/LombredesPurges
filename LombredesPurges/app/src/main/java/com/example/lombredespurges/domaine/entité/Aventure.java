package com.example.lombredespurges.domaine.entité;

import java.util.ArrayList;

public class Aventure {
    /**
     * Declaration des Aventure
     */
    private String _nomAventure;
    private ArrayList<Chapitre> _listeChapitre;


    /**
     * Constructeur d'une Aventure.
     */
    public Aventure(String _nomAventure, ArrayList<Chapitre> _listeChapitre) {
        this._nomAventure = _nomAventure;
        this._listeChapitre = _listeChapitre;
    }

    /**
     * Accesseurs du nom de l'aventure
     *
     * @return (String) le nom de l'aventure
     */
    public String get_nomAventure() {
        return _nomAventure;
    }

    /**
     * Accesseurs de la liste des chapitres
     *
     * @return (liste) la liste des chapitres
     */
    public ArrayList<Chapitre> get_listeChapitre() {
        return _listeChapitre;
    }


}
