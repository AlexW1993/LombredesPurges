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

    @Override
    public void getNomPersonnage(){
        String nom;
        //nom = _modèle.getPersonnage().get_nom();
        //_vue.afficherNomPersonnage(nom);
    }

    @Override
    public void getAttributsPersonnage(){
        ArrayList<Integer> attributs = new ArrayList();
        attributs.add(_modèle.get_jeu().get_personnage().get_force());
        attributs.add(_modèle.get_jeu().get_personnage().get_agilité());
        attributs.add(_modèle.get_jeu().get_personnage().get_endurance());
        _vue.afficherAttributsPersonnage(attributs);
    }

    @Override
    public void getNomEnnemie(){
        String nom;
        nom = _modèle.getEnnemie().get_nom();
        _vue.afficherNomEnnemie(nom);
    }

    @Override
    public void getAttributsEnnemie(){
        ArrayList<Integer> attributs = new ArrayList();
        attributs.add(_modèle.getEnnemie().get_force());
        attributs.add(_modèle.getEnnemie().get_agilité());
        attributs.add(_modèle.getEnnemie().get_endurance());
        _vue.afficherAttributsEnnemie(attributs);
    }

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
     * La méthode permet de comparer de l'endurance du personnage ou de l'ennemi à 0.
     *
     * @return (int) (1) si l'endurance du personnage est plus petite à 0,
     *               (2) si l'endurance de l'ennemie est plus petite à 0,
     *               (3) si l'endurance du personnage et l'ennemie sont  plus grand à 0,
     */
    @Override
    public void comparerEndurance(){
        /*if(_modèle.getPersonnage().get_endurance() <= 0){
            _vue.resultatEndurance(1);
        }else if(_modèle.getEnnemie().get_endurance() <= 0){
            _vue.resultatEndurance(2);
        }else {
            _vue.resultatEndurance(0);
        }*/
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

    @Override
    public void chercherPersonage(){
       /* _vue.envoiePersonnageDansProchaineVue(_modèle.getPersonnage());*/
    }

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
