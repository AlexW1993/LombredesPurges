package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.domaine.interacteur.Creation;

public class Modèle {

    /**
     * Declaration des Attributs
     */
    private static Modèle modèle;
    private Personnage _personnage;
    private Ennemie _ennemie;

    /**
     * La méthode permet la creation d'un modèle ou s'il existe, il va l'ajouter dans une variable.
     *
     * @return  (Modèle) le modèle de l'application.
     */
    public static Modèle getInstance(){
        if (modèle == null){
            modèle = new Modèle();
        }
        return modèle;
    }

    /**
     * La méthode permet d'appeler la methode pour la creation d'un personnage.
     *
     * @param (nom,force,endurance,agilité,intelligence), le nom et les attributs du personnage.
     */
    public void creationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _personnage = new Creation().CreationPersonnage(nom, force, endurance,agilité, intelligence);
    }

    /**
     * La méthode permet d'appeler la methode pour la creation d'un ennemie.
     */
    public void creationEnnemie( ){
        _ennemie = new Creation().CreationEnnemie();
    }

    /**
     * Accesseurs du personnage.
     *
     * @return le personnage.
     */
    public Personnage getPersonnage(){
        return _personnage;
    }

    /**
     * Accesseurs de l'ennemie.
     *
     * @return l'ennemi.
     */
    public Ennemie getEnnemie(){
        return _ennemie;
    }

    /**
     * La méthode permet d'appeler les methodes pour calculer la coeficience d'attaquer du personnage et de l'ennemie
     */
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

}
