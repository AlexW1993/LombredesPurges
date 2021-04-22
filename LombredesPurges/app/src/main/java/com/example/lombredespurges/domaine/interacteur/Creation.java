package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;

import java.util.Random;

public class Creation {

    public Personnage CreationPersonnage (String nom, int force, int endurance, int agilité, int intelligence){
        Personnage personnage;
        personnage = new Personnage(nom,force,endurance,agilité,intelligence);
        return  personnage;
    }

    public Ennemie CreationEnnemie (){
        Ennemie ennemie;
        int num,force,endurence,agilité,intelligence;
        num = new Random().nextInt((6 - 1) + 1) + 1;
        force = 10 + num;
        num = new Random().nextInt((10 - 1) + 1) + 1;
        endurence = 20 + (2 * num);
        num = new Random().nextInt((6 - 1) + 1) + 1;
        agilité = 10 + num;
        num = new Random().nextInt((6 - 1) + 1) + 1;
        intelligence = 5 + num;
        ennemie = new Ennemie("Purge",force,endurence,agilité,intelligence);
        return  ennemie;
    }
}
