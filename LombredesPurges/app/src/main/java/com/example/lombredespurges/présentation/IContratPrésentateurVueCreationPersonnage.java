package com.example.lombredespurges.présentation;

import android.os.Bundle;

import com.example.lombredespurges.domaine.entité.Personnage;

public interface IContratPrésentateurVueCreationPersonnage {

    public interface IPrésentateurCreationPersonnage{
        public void choisirRace(String nomRace);
        public void créationPersonnage(String nom, int force, int endurance, int agilité, int intelligence);
        public void calculerAttribut(String attribut);
    }


    public interface IVueCreationPersonnage{
        public void setRace(String race, int description, int codeImage);
        public void ajouterForcePersonnage(int pointsTotal);
        public void ajouterEndurancePersonnage(int pointsTotal);
        public void ajouterAgilitéPersonnage(int pointsTotal);
        public void ajouterIntelligencePersonnage(int pointsTotal);
    }
}
