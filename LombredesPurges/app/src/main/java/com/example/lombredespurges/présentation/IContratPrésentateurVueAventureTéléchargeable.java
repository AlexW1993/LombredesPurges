package com.example.lombredespurges.présentation;

public interface IContratPrésentateurVueAventureTéléchargeable {

    public interface IPrésentateurAventureTéléchargeable{
        public void gestionChapitre(int choix);
        public void réinitialierJeu();
    }

    public interface IVueAventureTéléchargeable {
        public void afficherAventure(int numeroChapitre, String idContenueChapitre,String idChoix1,String idChoix2,String idChoix3);
        public void afficherFinJeu(String nomPersonnage, String idContenueChapitre);
        public void passerAuCombat();
        public void passerPageTitre();
    }

}
