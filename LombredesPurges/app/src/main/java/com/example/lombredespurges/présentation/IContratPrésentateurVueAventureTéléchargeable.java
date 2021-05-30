package com.example.lombredespurges.présentation;

import android.content.Context;

public interface IContratPrésentateurVueAventureTéléchargeable {

    public interface IPrésentateurAventureTéléchargeable{
        public void gestionChapitre(int choix);
        public void réinitialierJeu();
    }

    public interface IVueAventureTéléchargeable {
        public void afficherAventure(int numeroChapitre, String idContenueChapitre, int[] choix, String[] descriptionChoix, Context context);
        public void afficherFinJeu(String nomPersonnage, String idContenueChapitre);
        public void passerAuCombat();
        public void passerPageTitre();
    }

}
