package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.Personnage;

import java.util.ArrayList;

public interface IContratPrésentateurVueCombat {

    public interface IPrésentateurCombat{
        public void creationEnnemie();
        public void getNomPersonnage();
        public void getAttributsPersonnage();
        public void getNomEnnemie();
        public void getAttributsEnnemie();
        public void tourDAttaquer(boolean tourJoueur);
        public void comparerEndurance();
        public void calculerCoefAttaque();
        public void faireAccionAttaquer(int accion, boolean tourJoueur);
        public void chercherPersonage();
        public void changerRace(String race);
    }

    public interface IVueCombat{
        public void afficherNomPersonnage(String unNom);
        public void afficherAttributsPersonnage(ArrayList<Integer> attributs);
        public void afficherNomEnnemie(String unNom);
        public void afficherAttributsEnnemie(ArrayList<Integer> attributs);
        public void afficherCoefAttaque(int coefAttaqueP, int coefAttaqueE, boolean resultatComparaison);
        public void gestionAccion(int accion);
        public void setTextDefencéEndurenceEnnemie(int defenceEnnemie, int endurenceEnnemie);
        public void setTextDefencéEndurencePersonnage(int defencePersonnage, int endurencePersonnage);
        public void faireAction1(int dommage);
        public void faireAction2(int dommage);
        public void faireAction3(int dommage);
        public void faireAction4(int dommage);
        public void resultatEndurance(int resultat);
        public void envoiePersonnageDansProchaineVue(Personnage personnage);
        public void actionChangerRace(int race);
    }
}
