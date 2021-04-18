package com.example.lombredespurges.modèle;

import java.util.Random;

public class Ennemie {

    /**
     * Declaration des Attributs
     */
    private String _nom;
    private int _force;
    private int _endurance;
    private int _agilité;
    private int _intelligence;
    private int coefAttaque;
    private int coefDéfence;
    private int dommages;

    /**
     * Constructeur d'un Ennemie.
     */
    public Ennemie(String _nom, int _force, int _endurance, int _agilité, int _intelligence) {
        this._nom = _nom;
        this._force = _force;
        this._endurance = _endurance;
        this._agilité = _agilité;
        this._intelligence = _intelligence;
    }

    /**
     * Accesseurs du nom du ennemie.
     *
     * @return le nom du ennemie..
     */
    public String get_nom() {
        return _nom;
    }

    /**
     * Accesseurs de la force d'un ennemie.
     *
     * @return (int) la force total du ennemie.
     */
    public int get_force() {
        return _force;
    }

    /**
     * Accesseurs de l'endurance d'un ennemie.
     *
     * @return (int) l'endurance total du ennemie.
     */
    public int get_endurance() {
        return _endurance;
    }

    /**
     * Accesseurs de l'agilité d'un ennemie.
     *
     * @return (int) l'agilité total du ennemie.
     */
    public int get_agilité() {
        return _agilité;
    }

    /**
     * Accesseurs de la coeficience d'attaque d'un ennemie.
     *
     * @return (int) la coeficience d'attaque total du ennemie.
     */
    public int getCoefAttaque() {
        return coefAttaque;
    }

    /**
     * Accesseurs de la coeficience de défence d'un ennemie.
     *
     * @return (int) la coeficience de défence total du ennemie.
     */
    public int getCoefDéfence() {
        return coefDéfence;
    }

    /**
     * Accesseurs du dommages d'un ennemie.
     *
     * @return (int) (int) la total du dommages.
     */
    public int getDommages() {
        return dommages;
    }

    /**
     * La méthode permet de calculer la coeficience d'attaque
     * total d'un ennemie.
     */
    public void calculerCoefAttaqueEnnemi(){
        int dé = new Random().nextInt((6 - 1) + 1) + 1;
        coefAttaque = _agilité + dé;
    }

    /**
     * La méthode permet de calculer la coeficience de Défence
     * total d'un ennemie.
     *
     * @param coefAttaqueAttaquant, la coeficience d'attaque du personnage.
     */
    public void calculerCoefDéfense(int coefAttaqueAttaquant){
        coefDéfence = coefAttaqueAttaquant - coefAttaque;
    }

    /**
     * La méthode permet de calculer le dommage que l'ennemie a reçu.
     *
     * @param forceAttaquant, la force d'attaque du personnage.
     */
    public void calculerEtRecevoirDommage(int forceAttaquant){
        dommages = coefDéfence * forceAttaquant;
        _endurance -= dommages;
    }
}
