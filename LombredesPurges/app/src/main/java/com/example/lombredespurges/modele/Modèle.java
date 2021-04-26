

package com.example.lombredespurges.modele;

import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Jeu;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.domaine.interacteur.Creation;

public class Modèle {

    /**
     * Declaration des Attributs
     */
    private static Modèle modèle;
    private Jeu _jeu;
    private Ennemie _ennemie;

    /**
     * La méthode permet la creation d'un modèle ou s'il existe, il va l'ajouter dans une variable.
     *
     * @return  (Modèle) le modèle de l'application.
     */

    private Modèle(){
        this._jeu = new Creation().CréationJeu();
    }

    public static Modèle getInstance(){
        if (modèle == null){
            modèle = new Modèle();
        }
        return modèle;
    }


    public void réanitialierJeu(){
        this._jeu = new Creation().CréationJeu();
    }
    /**
     * La méthode permet d'appeler la methode pour la creation d'un personnage.
     *
     * @param (nom,force,endurance,agilité,intelligence), le nom et les attributs du personnage.
     */
    public void creationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _jeu.set_personnage(new Personnage(nom, force, endurance, agilité, intelligence));
    }


    public Chapitre déterminerChapitreCourant(){
        return _jeu.get_aventureChoisie().getChapitreCourante();
    }

    public void passerAuProchainChapitre(int choix){
        _jeu.get_aventureChoisie().passerAuProchainChapitre(choix);
    }



    public void determinerAventureChoisie(String nomAventure){
        _jeu.determinerAventureChoisie(nomAventure);
    }

    public Jeu get_jeu(){
        return _jeu;
    }

    /**
     * La méthode permet d'appeler la methode pour la creation d'un ennemie.
     */
    public void creationEnnemie( ){
        _ennemie = new Creation().CreationEnnemie();
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
        _jeu.get_personnage().calculerCoefAttaquePersonnage();
    }

    /**
     * La méthode permet de comparer le coeficience d'attaquer du personnage avec
    * la coeficience d'attaque de l'ennemie.
    *
    * @return (boolean) (true) si le coeficience d'attaque du personnage est plus grand
    * ou égale, (false) si le coeficience d'attaque de l'ennemie est plus grand.
    */
    public boolean comparaisonCoefAttaque(){
        if(_jeu.get_personnage().getCoefAttaque() >= _ennemie.getCoefAttaque()){
            return true;
        }else{
            return false;
        }
    }


}
