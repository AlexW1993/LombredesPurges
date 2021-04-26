package com.example.lombredespurges.présentation;


public interface IContratPrésentateurVueHistoires {

    public interface IPrésentateurHistoires{
        public void gestionChapitre(int choix);
        public void réinitialierJeu();
    }

    public interface IVueHistoire {
        public void afficherAventure(int numeroChapitre, int idContenueChapitre,int idChoix1,int idChoix2,int idChoix3);
        public void afficherFinJeu(int numeroChapitre, int idContenueChapitre);
        public void passerAuCombat();
        public void passerPageTitre();
    }
}
