package com.example.lombredespurges.présentation.présentateur;

import com.example.lombredespurges.VueCreationPersonnage;
import com.example.lombredespurges.R;
import com.example.lombredespurges.domaine.entité.Personnage;

import java.util.Random;


public class PresentateurCreationPersonnage {

    /**
     * Declaration des Attributs
     */
    private VueCreationPersonnage _vueCreationPersonnage;
    private Personnage _personnage;

    /**
     * Constructeur du presentateur du creationPersonnage.
     *
     * @param vueCreationPersonnage, la vue CreationPersonnage.
     */
    public PresentateurCreationPersonnage(VueCreationPersonnage vueCreationPersonnage){
        this._vueCreationPersonnage = vueCreationPersonnage;
    }

    /**
     * La méthode permet de analiser le choix du race.
     *
     * @return (String) la race choisi.
     */
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

    /**
     * La méthode permet de retoruner la description de la race de l'histoire.
     *
     * @param nomRace, (String) la race de l'histoire
     *
     * @return (String) la description de la race.
     */
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

    /**
     * La méthode permet de creer un personnage.
     *
     * @param (nom,force,endurance,agilité,intelligence), (String) le nom du personnage,
     *                                                    (int) la valeur de chaque attribut.
     */
    public void creationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _personnage = new  Personnage(nom, force, endurance, agilité, intelligence);
    }

    /**
     * Accesseurs du personnage.
     *
     * @return (Personnage) le personnage.
     */
    public Personnage get_personnage() {

        return _personnage;
    }

    /**
     * La méthode permet de calculer la force du personnage.
     *
     * @return (int) La force que le personnage aura.
     */
    public int calculerForce (){
        int num = new Random().nextInt((6 - 1) + 1) + 1;
        return 10 + num;
    }

    /**
     * La méthode permet de calculer l'endurance du personnage.
     *
     * @return (int) L'endurance que le personnage aura.
     */
    public int calculerEndurence(){
        int num = new Random().nextInt((10 - 1) + 1) + 1;
        return 20 + (3 * num);
    }

    /**
     * La méthode permet de calculer l'agilité du personnage.
     *
     * @return (int) L'agilité que le personnage aura.
     */
    public int calculerAgilité(){
        int num = new Random().nextInt((6 - 1) + 1) + 1;
        return 10 + num;
    }

    /**
     * La méthode permet de calculer l'intelligence du personnage.
     *
     * @return (int) L'intelligence que le personnage aura.
     */
    public int calculerIntelligence(){
        int num = new Random().nextInt((6 - 1) + 1) + 1;
        return 5 + num;
    }

    /**
     * La méthode permet de retourner le chapitre en utilisant le choix de race.
     *
     * @return (int) le choix de chapitre.
     */
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
