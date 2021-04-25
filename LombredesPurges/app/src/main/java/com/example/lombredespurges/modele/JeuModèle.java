package com.example.lombredespurges.modele;

import com.example.lombredespurges.domaine.entité.Aventure;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.domaine.interacteur.Creation;

import java.util.ArrayList;

public class JeuModèle {
    private ArrayList<Aventure> _listeAventure;
    private Personnage _personnage;
    private static JeuModèle leModèle;

    private JeuModèle(){
        this._listeAventure = new Creation().CréationListeAventures();
    }

    public static JeuModèle getJeuModèle(){
        if (leModèle == null){
            leModèle = new JeuModèle();
        }

        return leModèle;
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
}
