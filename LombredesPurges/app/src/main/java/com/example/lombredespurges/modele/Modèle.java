

package com.example.lombredespurges.modele;

import android.content.Context;

import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;
import com.example.lombredespurges.domaine.entité.Aventure;
import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AventureTéléchargeable;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.Chapters;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.Combats;
import com.example.lombredespurges.domaine.interacteur.Creation;
import com.example.lombredespurges.domaine.interacteur.RécupérerAventure;
import com.example.lombredespurges.domaine.interacteur.SauvegarderAventure;
import com.example.lombredespurges.domaine.interacteur.SourceDeDonnées;
import com.example.lombredespurges.source_de_données.SourceDeDonnéesHTTP;

import java.util.ArrayList;

public class Modèle {

    /**
     * Declaration des Attributs
     */
    private static Modèle modèle;
    private static int _numeroChapitreCourant;
    private Personnage _personnage;
    private Ennemie _ennemie;
    private ArrayList<Aventure> _listeAventure;
    private Aventure _aventureChoisie;
    private SourceDeDonnées _sourceHTTP;
    private SourceDeDonnées _sourceBD;
    private ArrayList<AutreAventure> _listeAutresAventuresServeur;
    private ArrayList<AutreAventure> _listeAutresAventuresBD;
    private ArrayList<AventureTéléchargeable> _listeAventuresTéléchargeableBD;
    private AventureTéléchargeable _aventureTéléchargeableChoisie;
    private Context _contexte;

    /**
     * Constructeur du Modèle.
     */
    private Modèle() {
        this._listeAventure = new Creation().CréationJeu();
    }

    /**
     * La méthode permet la creation d'un modèle ou s'il existe, il va l'ajouter dans une variable.
     *
     * @return (Modèle) le modèle de l'application.
     */
    public static Modèle getInstance() {
        if (modèle == null) {
            modèle = new Modèle();
        }
        return modèle;
    }

    /**
     * La méthode permet de réinitialiser la liste d'histoire dans le jeu.
     */
    public void réanitialierJeu() {

        this._listeAventure = new Creation().CréationJeu();
    }

    /**
     * La méthode permet d'appeler la methode pour la creation d'un personnage.
     *
     * @param (nom,force,endurance,agilité,intelligence), le nom et les attributs du personnage.
     */
    public void creationPersonnage(String nom, int force, int endurance, int agilité, int intelligence) {
        _personnage = new Creation().CreationPersonnage(nom, force, endurance, agilité, intelligence);
    }

    /**
     * La méthode permet retourer savoir quell'est el chapitre courante.
     *
     * @return (_aventureChoisie.getChapitreCourante ()) le  chapitre Courante.
     */
    public Chapitre déterminerChapitreCourant() {

        return _aventureChoisie.getChapitreCourante();
    }

    public Chapters getChapitreCourant() {
        return _aventureTéléchargeableChoisie.getChapterCourant();
    }

    /**
     * La méthode permet d'appeler la methode pour passer au prochaine chapitre.
     *
     * @param (choix), le choix que le joueur a fait pour le chapitre suivant.
     */
    public void passerAuProchainChapitre(int choix) {
        _aventureChoisie.passerAuProchainChapitre(choix);
    }

    /**
     * La méthode permet savoir l'aventure choisie pour le joueur.
     *
     * @param (nomAventure), l'aventure choisie.
     */
    public void determinerAventureChoisie(String nomAventure) {
        for (Aventure uneAventure : _listeAventure) {
            if (uneAventure.get_nomAventure().trim().equals(nomAventure)) {
                _aventureChoisie = uneAventure;
            }
        }
    }

    /**
     * La méthode permet d'appeler la methode pour la creation d'un ennemie.
     */
    public void creationEnnemie() {
        _ennemie = new Creation().CreationEnnemie();
    }

    public void creationEnnemieAventureTelecharge() {
        _ennemie = new Ennemie();
        Combats[] combats = _aventureTéléchargeableChoisie.getChapterCourant().getCombats();
        for (Combats combat : combats) {
            if (!combat.isTerminé()) {
                _ennemie.setNom(combat.getEnemy());
                _ennemie.setCoefAttaque(combat.getCombatskill());
                _ennemie.setEndurance(combat.getEndurance());
                _ennemie.setForce(combat.getForce());
                break;
            }
        }
    }

    /**
     * Accesseurs de l'ennemie.
     *
     * @return l'ennemi.
     */
    public Ennemie getEnnemie() {
        return _ennemie;
    }

    public void setCombat(int positionCombat) {
        _aventureTéléchargeableChoisie.getChapterCourant().getCombats()[positionCombat].setTerminé(true);
    }

    /**
     * Accesseurs du personnage.
     *
     * @return le personnage.
     */
    public Personnage getPersonnage() {
        return _personnage;
    }

    /**
     * Accesseurs de l'aventure Courante.
     *
     * @return l'aventure Courante.
     */
    public Aventure getAventureChoisie() {
        return _aventureChoisie;
    }

    public AventureTéléchargeable getAventureTéléchargeableChoisie() {
        return this._aventureTéléchargeableChoisie;
    }

    /**
     * La méthode permet d'appeler les methodes pour calculer la coeficience d'attaquer du personnage et de l'ennemie
     */
    public void calculerCoefAttaque() {
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
    public boolean comparaisonCoefAttaque() {
        if (_personnage.getCoefAttaque() >= _ennemie.getCoefAttaque()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Accesseurs du contexte.
     *
     * @return le contexte.
     */
    public Context get_contexte() {
        return _contexte;
    }

    /**
     * Mutateur du contexte
     *
     * @param ctx, le nouveau contexte
     */
    public void set_contexte(Context ctx) {
        _contexte = ctx;
    }

    /**
     * Mutateur de la sourceHTTP
     *
     * @param source, le nouvelle source
     */
    public void set_sourceHTTP(SourceDeDonnées source) {
        _sourceHTTP = source;
    }

    /**
     * Mutateur de la sourceBD
     *
     * @param source, le nouvelle source
     */
    public void set_sourceBD(SourceDeDonnées source) {
        _sourceBD = source;
    }

    /**
     * La méthode permet de cherhcer la liste de referece des aventures qui sont sauevgarder das une serveur
     *
     * @return (ArrayList < AutreAventure >) La liste de reference des aventures
     */
    public ArrayList<AutreAventure> chercherListeAventuresServeur() {
        if (_listeAutresAventuresServeur == null) {
            _listeAutresAventuresServeur = new RécupérerAventure(_sourceHTTP).récupérerListeAventureServeur();
        }
        return _listeAutresAventuresServeur;
    }

    /**
     * La méthode permet de cherhcer la liste de referece des aventures qui sont sauevgarder dans la BD
     *
     * @return (ArrayList < AutreAventure >) La liste de reference des aventures
     */
    public ArrayList<AutreAventure> chercherAventuresBD() {
        if (_listeAutresAventuresBD == null) {
            _listeAutresAventuresBD = new RécupérerAventure(_sourceBD).récupérerAventuresBD();
            _listeAventuresTéléchargeableBD = new RécupérerAventure(_sourceBD).récupérerAventuresTéléchargeablesBD();
        }
        return _listeAutresAventuresBD;
    }

    /**
     * La méthode permet de sauvegarder l'aventure dans la BD
     *
     * @param title, le title de l'aventure à sauvegarder
     */
    public void sauvegarderAventure(String title) {
        AutreAventure aventure = new AutreAventure();

        for (int i = 0; i < _listeAutresAventuresServeur.size(); i++) {
            if (_listeAutresAventuresServeur.get(i).getTitle().equals(title)) {
                aventure.setTitle(_listeAutresAventuresServeur.get(i).getTitle());
                aventure.setUrl(_listeAutresAventuresServeur.get(i).getUrl());
            }
        }
        SourceDeDonnées source = new SourceDeDonnéesHTTP(get_contexte(), aventure.getUrl());
        String aventureJson = new RécupérerAventure(source).récupérerAventureServeur();
        new SauvegarderAventure(_sourceBD).SauvegarderAventureBD(aventure, aventureJson);
        _listeAutresAventuresBD = new RécupérerAventure(_sourceBD).récupérerAventuresBD();
        _listeAventuresTéléchargeableBD = new RécupérerAventure(_sourceBD).récupérerAventuresTéléchargeablesBD();
    }

    /**
     * La méthode permet de chosir et garder dans l'attribut _aventureTéléchargeableChoisie l'aventure que
     * le joueur a choisit.
     *
     * @param titleAventure, le title de l'aventure que le joueur a choisit pour jouer.
     */
    public void aventureTéléchargeableÀJouer(String titleAventure) {
        for (int i = 0; i < _listeAventuresTéléchargeableBD.size(); i++) {
            if (_listeAventuresTéléchargeableBD.get(i).getTitle().equals(titleAventure)) {
                _aventureTéléchargeableChoisie = _listeAventuresTéléchargeableBD.get(i);
            }
        }
    }

    /**
     * Méthode qui permet de gérer vers quel chapitre se rendre
     */
    public Chapters gestionChapitreCorant() {
        return _aventureTéléchargeableChoisie.gestionChapitreCorant();
    }

    /**
     * Méthode qui permet de passer au chapitre suivant
     *
     * @param choix, le numéro du choix selectionné
     */
    public void passerAuProchainChapitreAventureTéléchargeable(int choix) {
        _aventureTéléchargeableChoisie.passerAuProchainChapitreAventureTéléchargeable(choix);
    }

    /**
     * Méthode qui de revenir au premier chapire
     */
    public void reinitialiserAvantureTelechargeable() {
        _aventureTéléchargeableChoisie.reinitialiserAvantureTelechargeable();
    }
}
