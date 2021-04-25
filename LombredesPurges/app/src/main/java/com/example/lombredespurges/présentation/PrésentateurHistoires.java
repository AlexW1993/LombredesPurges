package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.Aventure;
import com.example.lombredespurges.domaine.entité.Jeu;
import com.example.lombredespurges.modele.Modèle;

public class PrésentateurHistoires implements IContratPrésentateurVueHistoires.IPrésentateurHistoires {

    private IContratPrésentateurVueHistoires.IVueHistoire _vue;
    private Modèle _modèle;
    private  Jeu _jeu;
    private Aventure _aventure;


    public PrésentateurHistoires(IContratPrésentateurVueHistoires.IVueHistoire vue) {
        this._vue = vue;
        _modèle = Modèle.getInstance();
    }

    @Override
    public void getAventure(String nomAventure) {
        _jeu = _modèle.get_jeu();
        _jeu.determinerAventureChoisie(nomAventure);
        _aventure = _jeu.get_aventureChoisie();
        _vue.afficherAventure(nomAventure);
    }
/*
    @Override
    public void getCombat(int positionListe) {
        boolean combat;
        combat = _aventure.get_listeChapitre().get(positionListe).get_combat();
        _vue.déterminerCombat(combat);
    }
*/
    @Override
    public void getNumeroChapitre(int positionListe) {
        int numéroChapitre;
        numéroChapitre = _aventure.get_listeChapitre().get(positionListe).get_numéroChapitre();
        _vue.afficherNumeroChapitre(numéroChapitre);
    }

    @Override
    public void getTexteChapitre(int positionListe) {
        int texteChapitre;
        texteChapitre = _aventure.get_listeChapitre().get(positionListe).get_IdTexteChapitre();
        _vue.afficherTexteChapitre(texteChapitre);
    }

    @Override
    public int getChoixChapitre(int positionListe) {
        int choix;
        choix = _aventure.get_listeChapitre().get(positionListe).get_listeIdTexteChoix().get(positionListe);
        return choix;
    }

    @Override
    public void getProchainChapitre(int positionListe) {
        int prochainChapitre;
        prochainChapitre = _aventure.get_listeChapitre().get(positionListe).get_prochainChapitre(positionListe);
        _vue.afficherProchainChapitre(prochainChapitre);
    }

    @Override
    public void déterminerCombat(int positionListe, boolean finalitéCombat){
        boolean _combat;
        _combat = _aventure.get_listeChapitre().get(positionListe).get_combat();
        if( _combat && finalitéCombat == false){
            _vue.faireCombat();
        }
    }

    @Override
    public void gestionChapitres(int numéroChapitreCourant){
        for (int i = 0; i < 18; i++) {
            if(numéroChapitreCourant == i){
                _vue.afficherNumeroChapitre(i);
                _vue.afficherTexteChapitre(i);
                _vue.afficherChoixChapitre(i);
            }
        }
    }
    }
}
