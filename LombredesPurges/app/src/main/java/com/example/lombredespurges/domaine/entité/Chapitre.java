package com.example.lombredespurges.domaine.entité;

import java.util.ArrayList;

public class Chapitre {

    int _numéroChapitre;
    ArrayList<Integer> _listeProchainChapitre;
    boolean _combat;
    private int _IdTexteChapitre;
    private ArrayList<Integer> _listeIdTexteChoix;

    public Chapitre(int numéroChapitre, int idTexteChapitre, ArrayList<Integer> listeIdTexteChoix, ArrayList<Integer> listeProchainChapitre, boolean combat){
        this._numéroChapitre = numéroChapitre;
        this._IdTexteChapitre = idTexteChapitre;
        this._listeIdTexteChoix = listeIdTexteChoix;
        this._listeProchainChapitre = listeProchainChapitre;
        this._combat = combat;
    }

    /**
     * Accesseurs du numéro de Chapitre
     *
     * @return (int) le numéro de chapitre
     */
    public int get_numéroChapitre() {
        return _numéroChapitre;
    }
    /**
     * Accesseurs du texte de Chapitre
     *
     * @return (int) le numéro référent au texte de chapitre
     */
    public int get_IdTexteChapitre() {
        return _IdTexteChapitre;
    }
    /**
     * Accesseurs de la liste de choix
     *
     * @return (ArrayList) liste de numéro référent aux choix
     */
    public ArrayList<Integer> get_listeIdTexteChoix() {
        return _listeIdTexteChoix;
    }

    /**
     * Accesseurs du combat
     *
     * @return (boolean) vrai s'il y a un combat sinon faux
     */
    public boolean get_combat() {
        return _combat;
    }

    /**
     * Accesseurs du prochain chapitre
     *
     * @return (int) le numéro du prochain chapitre
     */
    public int get_prochainChapitre(int positionListe) {
        return _listeProchainChapitre.get(positionListe);
    }
}
