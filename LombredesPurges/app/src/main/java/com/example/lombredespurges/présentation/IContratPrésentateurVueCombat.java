package com.example.lombredespurges.présentation;

import java.util.ArrayList;

public interface IContratPrésentateurVueCombat {

    public interface IPrésentateurCombat {
        public void creationEnnemie(String typeAventure);

        public void getNomPersonnage();

        public void getAttributsPersonnage();

        public void getNomEnnemie();

        public void getAttributsEnnemie();

        public void tourDAttaquer(boolean tourJoueur);

        public void calculerCoefAttaque();

        public void faireAccionAttaquer(int accion, boolean tourJoueur);

        public void changerRace();

        public void passerAuChapitreApresCombat(String typeAventure);

        public void passerPageTitre();
    }

    public interface IVueCombat {
        public void afficherAttributsPersonnage(ArrayList<Integer> attributs, String nom);

        public void afficherNomEnnemie(String unNom);

        public void afficherAttributsEnnemie(ArrayList<Integer> attributs);

        public void afficherCoefAttaque(int coefAttaqueP, int coefAttaqueE, boolean resultatComparaison);

        public void gestionAction(int accion);

        public void setTextDefencéEndurenceEnnemie(int defenceEnnemie, int endurenceEnnemie);

        public void setTextDefencéEndurencePersonnage(int defencePersonnage, int endurencePersonnage);

        public void faireAction1(int dommage);

        public void faireAction2(int dommage);

        public void faireAction3(int dommage);

        public void faireAction4(int dommage);

        public void actionChangerRace(int race);

        public void passerAuChapitre();

        public void passerAuChapitreTelechargeable();

        public void passerPageTitre();
    }
}
