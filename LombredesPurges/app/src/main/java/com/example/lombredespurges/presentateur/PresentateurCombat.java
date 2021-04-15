package com.example.lombredespurges.presentateur;

import com.example.lombredespurges.Combat;
import com.example.lombredespurges.modèle.Ennemie;
import com.example.lombredespurges.modèle.Personnage;

import java.util.Random;

public class PresentateurCombat {

    private Combat _combat;
    private Personnage _personnage;
    private Ennemie _ennemie;
    private PresentateurCreationPersonnage _presentateurCreationPersonnage;

    public PresentateurCombat(Combat vueCombat) {

        this._combat = vueCombat;
        creationEnnemie();
    }

    public void creationEnnemie(){
        _ennemie = new Ennemie("Purge",5,5,5,5);
        /*
        int num,force,endurence,agilité,intelligence;
        num = new Random().nextInt((6 - 1) + 1) + 1;
        force = 10 + num;
        num = new Random().nextInt((10 - 1) + 1) + 1;
        endurence = 20 + (2 * num);
        num = new Random().nextInt((6 - 1) + 1) + 1;
        agilité = 10 + num;
        num = new Random().nextInt((6 - 1) + 1) + 1;
        intelligence = 5 + num;
        _ennemie = new Ennemie("Purge",force,endurence,agilité,intelligence);*/
    }

    public String getNomEnnemie(){
        return this._ennemie.get_nom();
    }

    public int getForceEnnemie(){
        return this._ennemie.get_force();
    }

    public int getEndurenceEnnemie(){
        return this._ennemie.get_endurance();
    }

    public int getCoefAttaqueEnnemie(){
        return this._ennemie.getCoefAttaque();
    }

    public int getCoefDefencéEnnemie(){
        return this._personnage.getCoefDéfence();
    }

    public int getDommagesEnnemie(){
        return this._ennemie.getDommages();
    }

    public void Personnage(Personnage personnage){
        this._personnage = personnage;
    }

    public String getNomPersonnage(){
        return this._personnage.get_nom();
    }

    public int getForcePersonnage(){
        return this._personnage.get_force();
    }

    public int getEndurencePersonnage(){
        return this._personnage.get_endurance();
    }

    public int getAgilitéPersonnage(){
        return this._personnage.get_agilité();
    }

    public int getCoefAttaquePersonnage(){
        return this._personnage.getCoefAttaque();
    }

    public int getCoefDefencéPersonnage(){
        return this._personnage.getCoefDéfence();
    }

    public int getDommagesPersonnage(){
        return this._personnage.getDommages();
    }

    public boolean comparaisonCoefAttaque(){
        if(_personnage.getCoefAttaque() >= _ennemie.getCoefAttaque()){
            return true;
        }else{
            return false;
        }
    }

    public int tourDAttaquer(boolean tourJoueur){

        if (tourJoueur){
            _ennemie.calculerCoefDéfense(_personnage.getCoefAttaque());
            _ennemie.calculerEtRecevoirDommage(_personnage.get_force());
            if(_ennemie.get_endurance() <= 0){
                return 1;
            }else{
                return 2;
            }
        }else{
            _personnage.calculerCoefDéfense(_ennemie.getCoefAttaque());
            _personnage.calculerEtRecevoirDommage(_ennemie.get_force());
            if(_personnage.get_endurance() <= 0) {
                return 3;
            }else{
                return 4;
            }
        }
    }

    public int comparerEndurance(){
        if(_personnage.get_endurance() <= 0){
            return 1;
        }else if(_ennemie.get_endurance() <= 0){
            return 2;
        }else {
            return 0;
        }
    }

    public void calculerCoefAttaque(){
        _ennemie.calculerCoefAttaqueEnnemi();
        _personnage.calculerCoefAttaquePersonnage();
    }
}
