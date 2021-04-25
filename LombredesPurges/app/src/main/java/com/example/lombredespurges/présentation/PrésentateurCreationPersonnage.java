package com.example.lombredespurges.présentation;

import android.os.Bundle;
import com.example.lombredespurges.R;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.domaine.entité.Jeu;
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

    @Override
    public void informationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _modèle.creationPersonnage(nom, force, endurance, agilité, intelligence);
    }

    /**
     * Accesseurs du personnage.
     *
     * @return (Personnage) le personnage.
     */
    @Override
    public void chercherpersonnage(Bundle bundle) {
        Personnage personnage = _modèle.getPersonnage();
        _vue.ajouterPersonnage(personnage, bundle);
    }

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
     *
     * @return (int) le choix de chapitre.
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