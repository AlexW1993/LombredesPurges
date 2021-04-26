package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.Aventure;
import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.entité.Jeu;
import com.example.lombredespurges.modele.Modèle;

import java.util.ArrayList;

public class PrésentateurHistoires implements IContratPrésentateurVueHistoires.IPrésentateurHistoires {

    private IContratPrésentateurVueHistoires.IVueHistoire _vue;
    private Modèle _modèle;



    public PrésentateurHistoires(IContratPrésentateurVueHistoires.IVueHistoire vue) {
        this._vue = vue;
        _modèle = Modèle.getInstance();
    }

    @Override
    public void gestionChapitre(String nomAventure) {
        Jeu _jeu;
        Aventure _aventure;
        _jeu = _modèle.get_jeu();
        _jeu.determinerAventureChoisie(nomAventure); // on a l<aventure a jouer


        _aventure = _jeu.get_aventureChoisie();
        Chapitre uneChapitre = _aventure.getChapitreCourante();

        int numChapitre = uneChapitre.get_numéroChapitre();
        int idContenueChapitre = uneChapitre.get_IdTexteChapitre();
        ArrayList<Integer> listeIdChoix = uneChapitre.get_listeIdTexteChoix();

        if(listeIdChoix.isEmpty()){
            _vue.afficherFinJeu(numChapitre, idContenueChapitre);
        }else{
            int choix1 = listeIdChoix.get(0);
            int choix2 = listeIdChoix.get(1);
            int choix3 = listeIdChoix.get(3);

            _vue.afficherAventure(numChapitre, idContenueChapitre, choix1, choix2, choix3);
        }

    }

    public void determinerProchChap(){
        _modèle.chercherPrchChapitre();
    }



        //public void afficherAventure(String numeroChapitre, String contenueChapitre,String choix1,String choix2,String choix3);

        /*public void afficherAventure(String numeroChapitre, String contenueChapitre,String choix1,String choix2,String choix3) {
            txtNumeroChapitre.setText(numeroChapitre);
            texteContenueChapitre.setText(contenueChapitre);
            btnChoix1.setText(choix1);
            btnChoix2.setText(choix2);
            btnChoix3.setText(choix3);
        }*/

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
        //_vue.afficherNumeroChapitre(numéroChapitre);
    }

    @Override
    public void getTexteChapitre(int positionListe) {
        int texteChapitre;
        texteChapitre = _aventure.get_listeChapitre().get(positionListe).get_IdTexteChapitre();
        //_vue.afficherTexteChapitre(texteChapitre);
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
        //_vue.afficherProchainChapitre(prochainChapitre);
    }

    @Override
    public void déterminerCombat(int positionListe, boolean finalitéCombat){
        boolean _combat;
        _combat = _aventure.get_listeChapitre().get(positionListe).get_combat();
        if( _combat && finalitéCombat == false){
            //_vue.faireCombat();
        }
    }

    @Override
    public void gestionChapitres(int numéroChapitre) {

    }

    /*@Override
    public void gestionChapitres(int numéroChapitreCourant){
        for (int i = 0; i < 18; i++) {
            if(numéroChapitreCourant == i){
                _vue.afficherNumeroChapitre(i);
                _vue.afficherTexteChapitre(i);
                _vue.afficherChoixChapitre(i);
            }
        }
    }*/

}
