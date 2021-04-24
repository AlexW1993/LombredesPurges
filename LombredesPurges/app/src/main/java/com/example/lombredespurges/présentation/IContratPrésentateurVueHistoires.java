package com.example.lombredespurges.présentation;


public interface IContratPrésentateurVueHistoires {

    public interface IPrésentateurHistoires{
        public void getDéterminerCombat(int positionListe);
        public void getNumeroChapitre(int positionListe);
        public void getTexteChapitre(int positionListe);
        public void getChoix_1_Chapitre(int positionListe);
        public void getChoix_2_Chapitre(int positionListe);
        public void getChoix_3_Chapitre(int positionListe);
    }

    public interface IVueHistoireDino{
        public void afficherNumeroChapitre (int _numeroChapitre);
        public void afficherTexteChapitre (int _texteChapitre);
        public void afficherChoix_1_Chapitre (int _choix1);
        public void afficherChoix_2_Chapitre (int _choix2);
        public void afficherChoix_3_Chapitre (int _choix3);
        public void déterminerCombat (boolean _combat);

    }
}
