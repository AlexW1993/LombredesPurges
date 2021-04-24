package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.R;
import com.example.lombredespurges.domaine.entité.Aventure;
import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Jeu;
import com.example.lombredespurges.domaine.entité.Personnage;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        num = new Random().nextInt((3 - 1) + 1) + 1;
        force = 10 + num;
        num = new Random().nextInt((7 - 1) + 1) + 1;
        endurence = 20 + (2 * num);
        num = new Random().nextInt((3 - 1) + 1) + 1;
        agilité = 10 + num;
        num = new Random().nextInt((3 - 1) + 1) + 1;
        intelligence = 5 + num;
        ennemie = new Ennemie("Purge",force,endurence,agilité,intelligence);
        return  ennemie;
    }


    public Jeu CréationJeu(){
        ArrayList<Aventure> listeAventures = new ArrayList<Aventure>();
        listeAventures.add(CréationAventureDino());

        Jeu jeu = new Jeu(listeAventures);

        return jeu;
    }

    private Aventure CréationAventureDino(){
        ArrayList<Chapitre> listeChapitres = new ArrayList<Chapitre>();
        listeChapitres.add(CréationHistoireDinoChapitre0());
        listeChapitres.add(CréationHistoireDinoChapitre1());
        listeChapitres.add(CréationHistoireDinoChapitre2());
        listeChapitres.add(CréationHistoireDinoChapitre3());
        listeChapitres.add(CréationHistoireDinoChapitre4());
        listeChapitres.add(CréationHistoireDinoChapitre5());
        listeChapitres.add(CréationHistoireDinoChapitre6());
        listeChapitres.add(CréationHistoireDinoChapitre7());
        listeChapitres.add(CréationHistoireDinoChapitre8());
        listeChapitres.add(CréationHistoireDinoChapitre9());
        listeChapitres.add(CréationHistoireDinoChapitre10());
        listeChapitres.add(CréationHistoireDinoChapitre11());
        listeChapitres.add(CréationHistoireDinoChapitre12());
        listeChapitres.add(CréationHistoireDinoChapitre13());
        listeChapitres.add(CréationHistoireDinoChapitre14());
        listeChapitres.add(CréationHistoireDinoChapitre15());
        listeChapitres.add(CréationHistoireDinoChapitre16());
        listeChapitres.add(CréationHistoireDinoChapitre17());
        listeChapitres.add(CréationHistoireDinoChapitre18());

        Aventure dino = new Aventure("Dino",listeChapitres);

        return dino;
    }

    private Chapitre CréationHistoireDinoChapitre0(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix0_1);
        listeChoix.add(R.string.choix0_2);
        listeChoix.add(R.string.choix0_3);
        listeProchain.add(R.string.chapitre1Dino);
        listeProchain.add(R.string.chapitre2Dino);
        listeProchain.add(R.string.chapitre3Dino);

        chapitre = new Chapitre(0,R.string.chapitre0Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre1(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix1_1);
        listeChoix.add(R.string.choix2_2);
        listeChoix.add(R.string.choix3_3);
        listeProchain.add(R.string.chapitre4Dino);
        listeProchain.add(R.string.chapitre5Dino);
        listeProchain.add(R.string.chapitre6Dino);

        chapitre = new Chapitre(1, R.string.chapitre1Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre2(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix2_1);
        listeChoix.add(R.string.choix2_2);
        listeChoix.add(R.string.choix2_3);
        listeProchain.add(R.string.chapitre4Dino);
        listeProchain.add(R.string.chapitre5Dino);
        listeProchain.add(R.string.chapitre6Dino);
        chapitre = new Chapitre(2, R.string.chapitre2Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre3(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix3_1);
        listeChoix.add(R.string.choix3_2);
        listeChoix.add(R.string.choix3_3);
        listeProchain.add(R.string.chapitre9Dino);
        listeProchain.add(R.string.chapitre8Dino);
        listeProchain.add(R.string.chapitre7Dino);
        chapitre = new Chapitre(3, R.string.chapitre3Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre4(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix4_1);
        listeChoix.add(R.string.choix4_2);
        listeChoix.add(R.string.choix4_3);
        listeProchain.add(R.string.chapitre12Dino);
        listeProchain.add(R.string.chapitre10Dino);
        listeProchain.add(R.string.chapitre11Dino);
        chapitre = new Chapitre(4, R.string.chapitre4Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre5(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix5_1);
        listeChoix.add(R.string.choix5_2);
        listeChoix.add(R.string.choix5_3);
        listeProchain.add(R.string.chapitre12Dino);
        listeProchain.add(R.string.chapitre10Dino);
        listeProchain.add(R.string.chapitre11Dino);
        chapitre = new Chapitre(5, R.string.chapitre5Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre6(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        chapitre = new Chapitre(6, R.string.chapitre6Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre7(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(7, R.string.chapitre7Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre8(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix8_1);
        listeChoix.add(R.string.choix8_2);
        listeChoix.add(R.string.choix8_3);
        listeProchain.add(R.string.chapitre12Dino);
        listeProchain.add(R.string.chapitre10Dino);
        listeProchain.add(R.string.chapitre11Dino);
        chapitre = new Chapitre(8, R.string.chapitre8Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre9(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix9_1);
        listeChoix.add(R.string.choix9_2);
        listeChoix.add(R.string.choix9_3);
        listeProchain.add(R.string.chapitre12Dino);
        listeProchain.add(R.string.chapitre10Dino);
        listeProchain.add(R.string.chapitre11Dino);
        chapitre = new Chapitre(9, R.string.chapitre9Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre10(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix10_1);
        listeChoix.add(R.string.choix10_2);
        listeChoix.add(R.string.choix10_3);
        listeProchain.add(R.string.chapitre15Dino);
        listeProchain.add(R.string.chapitre13Dino);
        listeProchain.add(R.string.chapitre14Dino);
        chapitre = new Chapitre(10, R.string.chapitre10Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre11(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix11_1);
        listeChoix.add(R.string.choix11_2);
        listeChoix.add(R.string.choix11_3);
        listeProchain.add(R.string.chapitre16Dino);
        listeProchain.add(R.string.chapitre17Dino);
        listeProchain.add(R.string.chapitre18Dino);
        chapitre = new Chapitre(11, R.string.chapitre11Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre12(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(12, R.string.chapitre12Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre13(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(13, R.string.chapitre13Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre14(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(14, R.string.chapitre14Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre15(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(15, R.string.chapitre15Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre16(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(16, R.string.chapitre16Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre17(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(17, R.string.chapitre17Dino,listeChoix,listeProchain,false);

        return chapitre;
    }

    private Chapitre CréationHistoireDinoChapitre18(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(18, R.string.chapitre18Dino,listeChoix,listeProchain,false);

        return chapitre;
    }



    /*public ArrayList<Histoire> CréationListeHistoireDino() {
        ArrayList<Histoire> listeHistoireDino = new ArrayList<Histoire>();
        listeHistoireDino.add(CréationHistoireDinoChapitre1());
        listeHistoireDino.add(CréationHistoireDinoChapitre2_1());
        listeHistoireDino.add(CréationHistoireDinoChapitre2_2());
        listeHistoireDino.add(CréationHistoireDinoChapitre2_3());
        listeHistoireDino.add(CréationHistoireDinoChapitre3_1());
        listeHistoireDino.add(CréationHistoireDinoChapitre3_2());
        listeHistoireDino.add(CréationHistoireDinoChapitre3_3());
        listeHistoireDino.add(CréationHistoireDinoChapitre3_4());
        listeHistoireDino.add(CréationHistoireDinoChapitre3_5());
        listeHistoireDino.add(CréationHistoireDinoChapitre3_6());
        listeHistoireDino.add(CréationHistoireDinoChapitre4_1());
        listeHistoireDino.add(CréationHistoireDinoChapitre4_2());
        listeHistoireDino.add(CréationHistoireDinoChapitre_Fin1());
        listeHistoireDino.add(CréationHistoireDinoChapitre_Fin2());
        listeHistoireDino.add(CréationHistoireDinoChapitre_Fin3());
        listeHistoireDino.add(CréationHistoireDinoChapitre_Fin4());
        listeHistoireDino.add(CréationHistoireDinoChapitre_Fin5());
        listeHistoireDino.add(CréationHistoireDinoChapitre_Fin6());

        return listeHistoireDino;
    }*/
}
