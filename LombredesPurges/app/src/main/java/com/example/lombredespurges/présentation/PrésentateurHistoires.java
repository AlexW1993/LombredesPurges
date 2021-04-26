package com.example.lombredespurges.présentation;

import com.example.lombredespurges.R;
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
    public void gestionChapitre(int choix) {
        if(choix != -1){
            _modèle.passerAuProchainChapitre(choix);
        }

        Chapitre uneChapitre = _modèle.déterminerChapitreCourant();

        if(uneChapitre.get_combat()){
            _vue.passerAuCombat();
        }

        int numChapitre = uneChapitre.get_numéroChapitre();
        int idContenueChapitre = uneChapitre.get_IdTexteChapitre();
        ArrayList<Integer> listeIdChoix = uneChapitre.get_listeIdTexteChoix();

        if(listeIdChoix.isEmpty()){
            _vue.afficherFinJeu(numChapitre, idContenueChapitre);
        }else{
            int choix1 = listeIdChoix.get(0);
            int choix2 = listeIdChoix.get(1);
            int choix3 = listeIdChoix.get(2);

            _vue.afficherAventure(numChapitre, idContenueChapitre, choix1, choix2, choix3);
        }
    }

    @Override
    public void réinitialierJeu() {
        _modèle.réanitialierJeu();
        _vue.passerPageTitre();
    }

    @Override
    public void changerRace() {

        String race = _modèle.get_jeu().get_aventureChoisie().get_nomAventure();
        if (race.equals("Via")) {
            _vue.actionChangerRace(R.drawable.via);
        } else if (race.equals("Kachikam")) {
            _vue.actionChangerRace(R.drawable.kaqchikam);
        } else if (race.equals("Dino")) {
            _vue.actionChangerRace(R.drawable.dinoh);
        }
    }
}
