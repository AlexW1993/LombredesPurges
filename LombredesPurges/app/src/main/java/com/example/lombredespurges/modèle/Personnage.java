package com.example.lombredespurges.modèle;

import java.io.Serializable;
import java.util.Random;

public class Personnage implements Serializable {
    private String _nom;
    private int _force;
    private int _endurance;
    private int _agilité;
    private int _intelligence;
    private int coefAttaque;
    private int coefDéfence;
    private int dommages;


    public Personnage(String _nom, int _force, int _endurance, int _agilité, int _intelligence) {
        this._nom = _nom;
        this._force = _force;
        this._endurance = _endurance;
        this._agilité = _agilité;
        this._intelligence = _intelligence;
    }

    public String get_nom() {
        return _nom;
    }

    public int get_force() {
        return _force;
    }

    public int get_endurance() {
        return _endurance;
    }

    public int get_agilité() {
        return _agilité;
    }

    public int get_intelligence() {
        return _intelligence;
    }

    public int getCoefAttaque() {
        return coefAttaque;
    }

    public void calculerCoefAttaquePersonnage(){
        int dé = new Random().nextInt((6 - 1) + 1) + 1;
        coefAttaque = _agilité + dé;
    }

    public int getCoefDéfence() {
        return coefDéfence;
    }

    public int getDommages() {
        return dommages;
    }

    public void calculerCoefDéfense(int coefAttaqueAttaquant){
        coefDéfence = coefAttaqueAttaquant - coefAttaque;
    }

    public void calculerEtRecevoirDommage(int forceAttaquant){
        dommages = coefDéfence * forceAttaquant;
        _endurance -= dommages;
    }


}
