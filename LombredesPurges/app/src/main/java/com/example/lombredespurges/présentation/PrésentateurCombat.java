package com.example.lombredespurges.présentation;

import com.example.lombredespurges.R;
import com.example.lombredespurges.modele.Modèle;

import java.util.ArrayList;


public class PrésentateurCombat implements IContratPrésentateurVueCombat.IPrésentateurCombat{

    /**
     * Declaration des Attributs
     */
    private IContratPrésentateurVueCombat.IVueCombat _vue;
    private Modèle _modèle;

    /**
     * Constructeur du presentateur du combat.
     *
     * @param vue, la vue Combat.
     */
    public PrésentateurCombat(IContratPrésentateurVueCombat.IVueCombat vue) {

        this._vue = vue;
        _modèle = Modèle.getInstance();
    }

    /**
     * La méthode permet de creer une ennemie avec tous ses attibuts.
     */
    @Override
    public void creationEnnemie(){
       _modèle.creationEnnemie();
    }

    /**
     * La méthode permet de chercher et afficher le nom du personnage.
     */
    @Override
    public void getNomPersonnage(){
        String nom;
    }

    /**
     * La méthode permet de chercher et afficher tous les attributs du personnage.
     */
    @Override
    public void getAttributsPersonnage(){
        ArrayList<Integer> attributs = new ArrayList();
        attributs.add(_modèle.get_jeu().get_personnage().get_force());
        attributs.add(_modèle.get_jeu().get_personnage().get_agilité());
        attributs.add(_modèle.get_jeu().get_personnage().get_endurance());
        _vue.afficherAttributsPersonnage(attributs);
    }

    /**
     * La méthode permet de chercher et afficher le nom de l'ennemi.
     */
    @Override
    public void getNomEnnemie(){
        String nom;
        nom = _modèle.getEnnemie().get_nom();
        _vue.afficherNomEnnemie(nom);
    }

    /**
     * La méthode permet de chercher et afficher tous les attributs de l'ennemi.
     */
    @Override
    public void getAttributsEnnemie(){
        ArrayList<Integer> attributs = new ArrayList();
        attributs.add(_modèle.getEnnemie().get_force());
        attributs.add(_modèle.getEnnemie().get_agilité());
        attributs.add(_modèle.getEnnemie().get_endurance());
        _vue.afficherAttributsEnnemie(attributs);
    }

    /**
     * La méthode permet faire une accion d'attaque en dependant si c'est l'ennemi ou si c'est le personnage.
     *
     * @param tourJoueur, (boolean) vrai si c'est le tour du personnage, faux si ce n'est pas le tur de personnage.
     */
    @Override
    public void tourDAttaquer(boolean tourJoueur){

        if (tourJoueur){
            _modèle.getEnnemie().calculerCoefDéfense(_modèle.get_jeu().get_personnage().getCoefAttaque());
            _modèle.getEnnemie().calculerEtRecevoirDommage(_modèle.get_jeu().get_personnage().get_force());
            if(_modèle.getEnnemie().get_endurance() <= 0){
                _vue.gestionAction(1);
            }else{
                _vue.gestionAction(2);
            }
        }else{
            _modèle.get_jeu().get_personnage().calculerCoefDéfense(_modèle.getEnnemie().getCoefAttaque());
            _modèle.get_jeu().get_personnage().calculerEtRecevoirDommage(_modèle.getEnnemie().get_force());
            if(_modèle.get_jeu().get_personnage().get_endurance() <= 0) {
                _vue.gestionAction(3);

            }else{
                _vue.gestionAction(4);
            }
        }
    }

    /**
     * La méthode permet de calculer la coeficience d'attaque du personnage
     * et de l'ennemie.
     */
    @Override
    public void calculerCoefAttaque(){
        _modèle.calculerCoefAttaque();
        _modèle.comparaisonCoefAttaque();

        _vue.afficherCoefAttaque(_modèle.get_jeu().get_personnage().getCoefAttaque(),_modèle.getEnnemie().getCoefAttaque(),_modèle.comparaisonCoefAttaque());
    }

    /**
     * La méthode permet faire une accion d'attaque en dependant si c'est l'ennemi qui auras des dommages ou si c'est le personnage.
     *
     * @param (accion,tourJoueur) .(int) l'action à realiser, (boolean) vrai si c'est le tour du personnage, faux si ce n'est pas le tur de personnage.
     */
    @Override
    public void faireAccionAttaquer(int accion, boolean tourJoueur){
        int dommage = 0;
        if (tourJoueur){
            _vue.setTextDefencéEndurenceEnnemie(_modèle.getEnnemie().getCoefDéfence(),_modèle.getEnnemie().get_endurance());
            if(accion == 1){
                dommage = _modèle.getEnnemie().getDommages();
                _vue.faireAction1(dommage);
            }else if (accion == 2){
                dommage = _modèle.getEnnemie().getDommages();
                _vue.faireAction2(dommage);
            }
        }else{
            _vue.setTextDefencéEndurencePersonnage(_modèle.get_jeu().get_personnage().getCoefDéfence(),_modèle.get_jeu().get_personnage().get_endurance());
            if(accion == 3) {
                dommage = _modèle.get_jeu().get_personnage().getDommages();
                _vue.faireAction3(dommage);
            }else if (accion == 4){
                dommage = _modèle.get_jeu().get_personnage().getDommages();
                _vue.faireAction4(dommage);
            }
        }
    }

    /**
     * La méthode permet changer la race.
     *
     */
    @Override
    public void changerRace() {

        String race = _modèle.get_jeu().get_aventureChoisie().get_nomAventure();
        if (race.equals("Via")) {
            _vue.actionChangerRace(R.drawable.via);
        } else if (race.equals("Kachikam")) {
            _vue.actionChangerRace(R.drawable.kaqchikam);
        } else if (race.equals("Dino")) {
            _vue.actionChangerRace(R.drawable.dinoh);
        }
    }

    @Override
    public void passerAuChapitreApresCombat() {
        _modèle.get_jeu().get_aventureChoisie().getChapitreCourante().set_combat(false);
        _vue.passerAuChapitre();
    }

    @Override
    public void passerPageTitre() {
        _modèle.réanitialierJeu();
        _vue.passerPageTitre();
    }

}
