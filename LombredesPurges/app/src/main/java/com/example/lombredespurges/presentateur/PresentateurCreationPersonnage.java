package com.example.lombredespurges.presentateur;

import com.example.lombredespurges.CreationPersonnage;
import com.example.lombredespurges.R;
import com.example.lombredespurges.modèle.Personnage;

import java.util.Random;


public class PresentateurCreationPersonnage {

    private CreationPersonnage _creationPersonnage;
    private Personnage _personnage;

    public PresentateurCreationPersonnage(CreationPersonnage creationPersonnage){
        this._creationPersonnage = creationPersonnage;
    }

    public String choisirRace(String nomRace){
        String race = "";
        if (nomRace.equals("via")) {
            race = "V.I.A.";
        } else if (nomRace.equals("kaqchikam")) {
            race = "Kaqchikam" ;
        } else if (nomRace.equals("dino")) {
            race = "Dino";
        }
        return race;
    }

    public int descriptionRace(String nomRace){
        int description = 0;
        if (nomRace.equals("via")) {
            description = R.string.descriptionVia;
        } else if (nomRace.equals("kaqchikam")) {
            description = R.string.descriptionKaqchikam ;
        } else if (nomRace.equals("dino")) {
            description = R.string.descriptionDino;
        }
        return description;
    }

    public void creationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _personnage = new  Personnage(nom, force, endurance, agilité, intelligence);
    }

    public Personnage get_personnage() {
        return _personnage;
    }

    public int calculerForce (){
        int num = new Random().nextInt((6 - 1) + 1) + 1;
        return 10 + num;
    }

    public int calculerEndurence(){
        int num = new Random().nextInt((10 - 1) + 1) + 1;
        return 20 + (3 * num);
    }

    public int calculerAgilité(){
        int num = new Random().nextInt((6 - 1) + 1) + 1;
        return 10 + num;
    }

    public int calculerIntelligence(){
        int num = new Random().nextInt((6 - 1) + 1) + 1;
        return 5 + num;
    }

    public int choixChapitre(String nomRace){
        int choix = 0;
        if (nomRace.equals("dino")){
            choix = R.id.chapitre_dino;
        } else if (nomRace.equals("via")){
            choix = R.id.chapitre_via;
        } else if (nomRace.equals("kaqchikam")) {
            choix = R.id.chapitre_kachikam;
        }
        return choix;
    }
}
