package com.example.lombredespurges.présentation;

import android.os.Bundle;
import com.example.lombredespurges.R;
import com.example.lombredespurges.domaine.entité.Personnage;

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
     */
    @Override
    public void choisirRace(String nomRace){
        String race = "";
        int description = 0;
        int codeImage = 0;
        if (nomRace.equals("via")) {
            race = "V.I.A.";
            description = R.string.descriptionVia;
            codeImage = R.drawable.via;
        } else if (nomRace.equals("kaqchikam")) {
            race = "Kaqchikam" ;
            description = R.string.descriptionKaqchikam ;
            codeImage = R.drawable.kaqchikam;
        } else if (nomRace.equals("dino")) {
            race = "Dino";
            description = R.string.descriptionDino;
            codeImage = R.drawable.dinoh;
        }
        _vue.setRace(race,description,codeImage);
    }

    /**
     * La méthode permet d'avoir les information du personnage (nom,attributs) pour sa creation.
     *
     * @param (nom,force,endurance,agilité,intelligence), les information du personnage.
     */
    @Override
    public void informationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _modèle.creationPersonnage(nom, force, endurance, agilité, intelligence);
    }

    /**
     * La méthode permet de chercher le personnage du jeu pour l'enoyer dans la prochaine vue.
     */
    @Override
    public void chercherpersonnage(Bundle bundle) {
        Personnage personnage = _modèle.getPersonnage();
        _vue.ajouterPersonnage(personnage, bundle);
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
        if (attribut.equals("force") == true){
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

    /**
     * La méthode permet de retourner le chapitre en utilisant le choix de race.
     */
    @Override
    public void choixChapitre(String nomRace, Bundle bundle){
        int choix = 0;
        if (nomRace.equals("dino")){
            choix = R.id.chapitre_dino;
        } else if (nomRace.equals("via")){
            choix = R.id.chapitre_via;
        } else if (nomRace.equals("kaqchikam")) {
            choix = R.id.chapitre_kachikam;
        }
        _vue.afficherChapitre(choix,bundle);
    }
}