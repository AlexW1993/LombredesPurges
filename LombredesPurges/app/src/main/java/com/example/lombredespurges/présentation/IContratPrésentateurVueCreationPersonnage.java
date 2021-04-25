package com.example.lombredespurges.présentation;

import android.os.Bundle;

import com.example.lombredespurges.domaine.entité.Personnage;

public interface IContratPrésentateurVueCreationPersonnage {

    public interface IPrésentateurCreationPersonnage{
        public void choisirRace(String nomRace);
        public void informationPersonnage(String nom, int force, int endurance, int agilité, int intelligence);
        public void chercherpersonnage(Bundle bundle);
        public void calculerAttribut(String attribut);
        public void choixChapitre(String nomRace, Bundle bundle);
    }


    public interface IVueCreationPersonnage{
        public void setRace(String race, int description, int codeImage);



        public void afficherChapitre (int choix, Bundle bundle);
        public void ajouterPersonnage(Personnage unPersonnage, Bundle bundle);
        public void ajouterForcePersonnage(int pointsTotal);
        public void ajouterEndurancePersonnage(int pointsTotal);
        public void ajouterAgilitéPersonnage(int pointsTotal);
        public void ajouterIntelligencePersonnage(int pointsTotal);
    }
}
