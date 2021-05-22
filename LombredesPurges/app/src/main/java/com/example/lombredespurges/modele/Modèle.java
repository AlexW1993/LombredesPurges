

package com.example.lombredespurges.modele;

import android.content.Context;

import com.example.lombredespurges.domaine.entité.AutreAventure;
import com.example.lombredespurges.domaine.entité.Aventure;
import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.domaine.interacteur.Creation;
import com.example.lombredespurges.domaine.interacteur.RécupérerAventure;
import com.example.lombredespurges.domaine.interacteur.SauvegarderAventure;
import com.example.lombredespurges.domaine.interacteur.SourceDeDonnées;
import java.util.ArrayList;



public class Modèle {

    /**
     * Declaration des Attributs
     */
    private static Modèle modèle;
    private Personnage _personnage;
    private Ennemie _ennemie;
    private ArrayList<Aventure> _listeAventure;
    private Aventure _aventureChoisie;
    private SourceDeDonnées _source;
    private ArrayList<AutreAventure> _listeAutresAventuresServeur;
    private ArrayList<AutreAventure> _listeAutresAventuresBD;
    private Context _ctx;

    /**
     * Constructeur du Modèle.
     */
    private Modèle(){
        this._listeAventure = new Creation().CréationJeu();
    }

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
     * La méthode permet de réinitialiser la liste d'histoire dans le jeu.
     */
    public void réanitialierJeu(){
        this._listeAventure = new Creation().CréationJeu();
    }

    /**
     * La méthode permet d'appeler la methode pour la creation d'un personnage.
     *
     * @param (nom,force,endurance,agilité,intelligence), le nom et les attributs du personnage.
     */
    public void creationPersonnage(String nom, int force, int endurance, int agilité, int intelligence){
        _personnage = new Creation().CreationPersonnage(nom, force, endurance, agilité, intelligence);
    }

    /**
     * La méthode permet retourer savoir quell'est el chapitre courante.
     *
     * @return  (_aventureChoisie.getChapitreCourante()) le  chapitre Courante.
     */
    public Chapitre déterminerChapitreCourant(){
        return _aventureChoisie.getChapitreCourante();
    }

    /**
     * La méthode permet d'appeler la methode pour passer au prochaine chapitre.
     *
     * @param (choix), le choix que le joueur a fait pour le chapitre suivant.
     */
    public void passerAuProchainChapitre(int choix){
        _aventureChoisie.passerAuProchainChapitre(choix);
    }

    /**
     * La méthode permet savoir l'aventure choisie pour le joueur.
     *
     * @param (nomAventure), l'aventure choisie.
     */
    public void determinerAventureChoisie(String nomAventure){
        for( Aventure uneAventure : _listeAventure){
            if(uneAventure.get_nomAventure().trim().equals(nomAventure)){
                _aventureChoisie = uneAventure;
            }
        }
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
     * Accesseurs du personnage.
     *
     * @return le personnage.
     */
    public Personnage getPersonnage(){return _personnage;}

    /**
     * Accesseurs de l'aventure Courante.
     *
     * @return l'aventure Courante.
     */
    public Aventure getAventureChoisie(){return _aventureChoisie;}

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

    public void set_source(SourceDeDonnées source){
        _source = source;
    }

    public ArrayList<AutreAventure> chercherAventuresServeur(){
        if(_listeAutresAventuresServeur == null){
            _listeAutresAventuresServeur = new RécupérerAventure(_source).récupérerAventureServeur();
        }
        return  _listeAutresAventuresServeur;
    }

    public ArrayList<AutreAventure> chercherAventuresBD(){
        if(_listeAutresAventuresBD == null){
            _listeAutresAventuresBD = new RécupérerAventure(_source).récupérerAventuresBD();
        }
        return  _listeAutresAventuresBD;
    }

    public void ajouterContexte(Context ctx){
        _ctx = ctx;
    }

    public Context get_ctx(){
        return _ctx;
    }

    public void sauvegarderAventure(String title){
        AutreAventure aventure = new AutreAventure();
        for (int i = 0; i < _listeAutresAventuresServeur.size() ; i++) {
            if(_listeAutresAventuresServeur.get(i).getTitle() == title){
                aventure.setTitle(_listeAutresAventuresServeur.get(i).getTitle());
                aventure.setUrl(_listeAutresAventuresServeur.get(i).getUrl());
            }
        }
        new SauvegarderAventure(_source).SauvegarderAventureBD(aventure);
    }

}
