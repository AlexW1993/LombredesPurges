package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.domaine.interacteur.Creation;

import java.util.ArrayList;

public class Modèle {

    private static Modèle modèle;
    private Personnage _personnage;
    private Ennemie _ennemie;
    private ArrayList<Histoire> _listeHistoire = new Creation().CréationListeHistoireDino();

    public static Modèle getInstance(){
        if (modèle == null){
            modèle = new Modèle();
        }
        return modèle;
    }

    public void creationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _personnage = new Creation().CreationPersonnage(nom, force, endurance,agilité, intelligence);
    }

    public void creationEnnemie( ){
        _ennemie = new Creation().CreationEnnemie();
    }

    public Personnage getPersonnage(){
        return _personnage;
    }
/*
    public int getCoefAttaquePersonnage(){
        return _personnage.getCoefAttaque();
    }*/

    public Ennemie getEnnemie(){
        return _ennemie;
    }

    /*
    public int getCoefAttaqueEnnemie(){
        return _ennemie.getCoefAttaque();
    }*/

    public void calculerCoefAttaque(){
        _ennemie.calculerCoefAttaqueEnnemi();
        _personnage.calculerCoefAttaquePersonnage();
    }

/**
 * La méthode permet de comparer le coeficience d'attaquer du personnage avec
 * la coeficience d'attaque de l'ennemie.
 *
 * @return (boolean) (true) si le coeficience d'attaque du personnage est plus grand
 * ou égale, (false) si le coeficience d'attaque de l'ennemie est plus grand.
 */
    public boolean comparaisonCoefAttaque(){
        if(_personnage.getCoefAttaque() >= _ennemie.getCoefAttaque()){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Histoire> getListeHistoireDino(){
        return _listeHistoire;
    }

}
