package com.example.lombredespurges.domaine.entité;

import java.util.ArrayList;

public class Jeu {
    private ArrayList<Aventure> _listeAventure;

    public Jeu(ArrayList<Aventure> listeAventure){

        this._listeAventure = listeAventure;
    }

    public ArrayList<Aventure> get_listeAventure() {
        return _listeAventure;
    }
}
