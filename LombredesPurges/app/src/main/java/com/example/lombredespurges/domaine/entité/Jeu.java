package com.example.lombredespurges.domaine.entité;

import com.example.lombredespurges.domaine.interacteur.Creation;

import java.util.ArrayList;

public class Jeu {
    private ArrayList<Aventure> _listeAventure;
    private Personnage _personnage;
    private Aventure _aventureChoisie;


    public Jeu(ArrayList<Aventure> _listeAventure) {
        this._listeAventure = _listeAventure;
    }

    public ArrayList<Aventure> get_listeAventure() {

        return _listeAventure;
    }

    public Personnage get_personnage() {
        return _personnage;
    }

    public void set_personnage(Personnage _personnage) {
        this._personnage = _personnage;
    }

    public Aventure get_aventureChoisie() {
        return _aventureChoisie;
    }


    public void determinerAventureChoisie(String nomAventure){
        for( Aventure uneAventure : _listeAventure){
            if(uneAventure.get_nomAventure().trim().equals(nomAventure)){
                _aventureChoisie = uneAventure;
            }
        }
    }
}
