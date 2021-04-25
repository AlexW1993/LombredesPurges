package com.example.lombredespurges.présentation;


public interface IContratPrésentateurVueHistoires {

    public interface IPrésentateurHistoires{
        public void getAventure(String nomAventure);
        public void getNumeroChapitre(int positionListe);
        public void getTexteChapitre(int positionListe);
        public int getChoixChapitre(int positionListe);
        public void getProchainChapitre(int positionListe);
        public void déterminerCombat(int positionListe,  boolean finalitéCombat);
        public void gestionChapitres(int numéroChapitre);
    }

    public interface IVueHistoire {
        public void afficherAventure(String nomAventure);
        public void afficherNumeroChapitre (int _numeroChapitre);
        public void afficherTexteChapitre (int _texteChapitre);
        public void afficherChoixChapitre (int _choix);
        public void afficherProchainChapitre (int _prochainChapitre);
        public void faireCombat();
        public boolean finalitéCombat();
    }
}
