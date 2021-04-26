package com.example.lombredespurges.présentation;


public interface IContratPrésentateurVueHistoires {

    public interface IPrésentateurHistoires{
        public void gestionChapitre(String nomAventure);
        public void getNumeroChapitre(int positionListe);
        public void getTexteChapitre(int positionListe);
        public int getChoixChapitre(int positionListe);
        public void getProchainChapitre(int positionListe);
        public void déterminerCombat(int positionListe,  boolean finalitéCombat);
        public void gestionChapitres(int numéroChapitre);
    }

    public interface IVueHistoire {
        public void afficherAventure(int numeroChapitre, int idContenueChapitre,int idChoix1,int idChoix2,int idChoix3);
        public void afficherFinJeu(int numeroChapitre, int idContenueChapitre);
        public void passerAuCombat();



        //public void afficherNumeroChapitre (int _numeroChapitre);
        //public void afficherTexteChapitre (int _texteChapitre);
       // public void afficherChoixChapitre (int _choix);
        //public void afficherProchainChapitre (int _prochainChapitre);
        //public void faireCombat();
        //public boolean finalitéCombat();
    }
}
