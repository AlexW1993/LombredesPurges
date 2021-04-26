package com.example.lombredespurges.présentation;


public interface IContratPrésentateurVueHistoires {

    public interface IPrésentateurHistoires{
        public void gestionChapitre(int choix);
        public void réinitialierJeu();
        public void changerRace();

    }

    public interface IVueHistoire {
        public void afficherAventure(int numeroChapitre, int idContenueChapitre,int idChoix1,int idChoix2,int idChoix3);
        public void afficherFinJeu(String nomPersonnage, int idContenueChapitre);
        public void passerAuCombat();
        public void passerPageTitre();
        public void actionChangerRace(int race);
    }
}
