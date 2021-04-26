package com.example.lombredespurges.présentation;

import android.os.Bundle;
import com.example.lombredespurges.R;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.modele.Modèle;

import java.util.Random;


public class PrésentateurCreationPersonnage implements IContratPrésentateurVueCreationPersonnage.IPrésentateurCreationPersonnage {

    /**
     * Declaration des Attributs
     */
    private IContratPrésentateurVueCreationPersonnage.IVueCreationPersonnage _vue;
    private Modèle _modèle;

    /**
     * Constructeur du presentateur du creationPersonnage.
     *
     * @param vue, la vue CreationPersonnage.
     */
    public PrésentateurCreationPersonnage(IContratPrésentateurVueCreationPersonnage.IVueCreationPersonnage vue){
        this._vue = vue;
        _modèle = Modèle.getInstance();

    }

    /**
     * La méthode permet de analiser le choix du race.
     *
     */
    @Override
    public void choisirRace(String nomRace){
        int description = 0;
        int codeImage = 0;
        if (nomRace.equals("Via")) {
            description = R.string.descriptionVia;
            codeImage = R.drawable.via;
        } else if (nomRace.equals("Kachikam")) {
            description = R.string.descriptionKaqchikam ;
            codeImage = R.drawable.kaqchikam;
        } else if (nomRace.equals("Dino")) {
            description = R.string.descriptionDino;
            codeImage = R.drawable.dinoh;
        }
        _vue.setRace(nomRace,description,codeImage);
        _modèle.determinerAventureChoisie(nomRace);

    }

    /**
     * La méthode permet d'avoir les information du personnage (nom,attributs) pour sa creation.
     *
     * @param (nom,force,endurance,agilité,intelligence), les information du personnage.
     */
    @Override
    public void créationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _modèle.creationPersonnage(nom, force, endurance, agilité, intelligence);
    }

    /**
     * La méthode permet de calculer la valuer de l'attribut que est en parametre.
     *
     * @param attribut, (String) l'attribut a être calculer.
     */
    @Override
    public void calculerAttribut(String attribut){
        int num = 0;
        int total = 0;

        if (attribut.equals("force")){
            num = new Random().nextInt((6 - 1) + 1) + 1;
            total =  10 + num;
            _vue.ajouterForcePersonnage(total);

        } else if (attribut.equals("endurance") == true){
            num =  new Random().nextInt((10 - 1) + 1) + 1;
            total = 20 + (3 * num);
            _vue.ajouterEndurancePersonnage(total);
        } else if (attribut.equals("agilité") == true){
            num = new Random().nextInt((6 - 1) + 1) + 1;
            total =  10 + num;
            _vue.ajouterAgilitéPersonnage(total);
        } else if (attribut.equals("intelligence") == true){
            num = new Random().nextInt((6 - 1) + 1) + 1;
            total =  5 + num;
            _vue.ajouterIntelligencePersonnage(total);
        }
    }
}