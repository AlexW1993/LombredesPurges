package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.R;
import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;

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

    //(int numéroChapitre, int idTexteChapitre, ArrayList<Integer> listeIdTexteChoix, ArrayList<Integer> listeProchainChapitre, boolean combat)

    public Chapitre CréationHistoireDinoChapitre0(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre histoireDinoChapitre1;
        listeChoix.add(R.string.choix0_1);
        listeChoix.add(R.string.choix0_2);
        listeChoix.add(R.string.choix0_3);
        listeProchain.add(R.string.chapitre1Dino);
        listeProchain.add(R.string.chapitre2Dino);
        listeProchain.add(R.string.chapitre3Dino);

        histoireDinoChapitre1 = new Chapitre(0,R.string.chapitre0Dino,listeChoix,listeProchain,false);

        return histoireDinoChapitre1;
    }

    public Chapitre CréationHistoireDinoChapitre1(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre histoireDinoChapitre1;
        listeChoix.add(R.string.choix1_1);
        listeChoix.add(R.string.choix2_2);
        listeChoix.add(R.string.choix3_3);
        listeProchain.add(R.string.chapitre4Dino);
        listeProchain.add(R.string.chapitre5Dino);
        listeProchain.add(R.string.chapitre6Dino);

        histoireDinoChapitre1 = new Chapitre(2, R.string.chapitre1Dino,listeChoix,listeProchain,false);

        return histoireDinoChapitre1;
    }

    public Chapitre CréationHistoireDinoChapitre2(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre histoireDinoChapitre2;
        listeChoix.add(R.string.choix2_1);
        listeChoix.add(R.string.choix2_2);
        listeChoix.add(R.string.choix2_3);
        listeProchain.add(R.string.chapitre4Dino);
        listeProchain.add(R.string.chapitre5Dino);
        listeProchain.add(R.string.chapitre6Dino);
        histoireDinoChapitre2 = new Chapitre(2, R.string.chapitre2Dino,listeChoix,listeProchain,false);

        return histoireDinoChapitre2;
    }

    public Chapitre CréationHistoireDinoChapitre3(){
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre histoireDinoChapitre3;
        listeChoix.add(R.string.choix3_1);
        listeChoix.add(R.string.choix3_2);
        listeChoix.add(R.string.choix3_3);
        listeProchain.add(R.string.chapitre9Dino);
        listeProchain.add(R.string.chapitre8Dino);
        listeProchain.add(R.string.chapitre7Dino);
        histoireDinoChapitre3 = new Chapitre(3, R.string.chapitre3Dino,listeChoix,listeProchain,false);

        return histoireDinoChapitre3;
    }

    public Histoire CréationHistoireDinoChapitre3_1(){
        Histoire histoireDinoChapitre3_1;
        histoireDinoChapitre3_1 = new Histoire("Dino",3, R.string.chapitre3_1Dino,R.string.choix4_1,R.string.choix4_2,R.string.choix4_3,true);

        return histoireDinoChapitre3_1;
    }

    public Histoire CréationHistoireDinoChapitre3_2(){
        Histoire histoireDinoChapitre3_2;
        histoireDinoChapitre3_2 = new Histoire("Dino",3, R.string.chapitre3_2Dino,R.string.choix5_1,R.string.choix5_2,R.string.choix5_3,false);

        return histoireDinoChapitre3_2;
    }

    public Histoire CréationHistoireDinoChapitre3_3(){
        Histoire histoireDinoChapitre3_3;
        histoireDinoChapitre3_3 = new Histoire("Dino",3, R.string.chapitre3_3Dino,0,0,0,false);

        return histoireDinoChapitre3_3;
    }

    public Histoire CréationHistoireDinoChapitre3_4(){
        Histoire histoireDinoChapitre3_4;
        histoireDinoChapitre3_4 = new Histoire("Dino",3, R.string.chapitre3_4Dino,0,0,0,false);

        return histoireDinoChapitre3_4;
    }

    public Histoire CréationHistoireDinoChapitre3_5(){
        Histoire histoireDinoChapitre3_5;
        histoireDinoChapitre3_5 = new Histoire("Dino",3, R.string.chapitre3_5Dino,R.string.choix8_1,R.string.choix8_2,R.string.choix8_3,false);

        return histoireDinoChapitre3_5;
    }

    public Histoire CréationHistoireDinoChapitre3_6(){
        Histoire histoireDinoChapitre3_6;
        histoireDinoChapitre3_6 = new Histoire("Dino",3, R.string.chapitre3_6Dino,R.string.choix9_1,R.string.choix9_2,R.string.choix9_3,true);

        return histoireDinoChapitre3_6;
    }


    public Histoire CréationHistoireDinoChapitre4_1(){
        Histoire histoireDinoChapitre4_1;
        histoireDinoChapitre4_1 = new Histoire("Dino",4, R.string.chapitre4_1Dino,R.string.choix10_1,R.string.choix10_2,R.string.choix10_3,false);

        return histoireDinoChapitre4_1;
    }

    public Histoire CréationHistoireDinoChapitre4_2(){
        Histoire histoireDinoChapitre4_2;
        histoireDinoChapitre4_2 = new Histoire("Dino",4, R.string.chapitre4_2Dino,R.string.choix11_1,R.string.choix11_2,R.string.choix11_3,false);

        return histoireDinoChapitre4_2;
    }


    public Histoire CréationHistoireDinoChapitre_Fin1(){
        Histoire histoireDinoChapitre_fin1;
        histoireDinoChapitre_fin1 = new Histoire("Dino",4, R.string.chapitrefin12Dino,0,0,0,false);

        return histoireDinoChapitre_fin1;
    }

    public Histoire CréationHistoireDinoChapitre_Fin2(){
        Histoire histoireDinoChapitre_fin2;
        histoireDinoChapitre_fin2 = new Histoire("Dino",5, R.string.chapitrefin13Dino,0,0,0,false);

        return histoireDinoChapitre_fin2;
    }

    public Histoire CréationHistoireDinoChapitre_Fin3(){
        Histoire histoireDinoChapitre_fin3;
        histoireDinoChapitre_fin3 = new Histoire("Dino",5, R.string.chapitrefin14Dino,0,0,0,false);

        return histoireDinoChapitre_fin3;
    }

    public Histoire CréationHistoireDinoChapitre_Fin4(){
        Histoire histoireDinoChapitre_fin4;
        histoireDinoChapitre_fin4 = new Histoire("Dino",5, R.string.chapitrefin15Dino,0,0,0,false);

        return histoireDinoChapitre_fin4;
    }

    public Histoire CréationHistoireDinoChapitre_Fin5(){
        Histoire histoireDinoChapitre_fin5;
        histoireDinoChapitre_fin5 = new Histoire("Dino",5, R.string.chapitrefin16Dino,0,0,0,false);

        return histoireDinoChapitre_fin5;
    }

    public Histoire CréationHistoireDinoChapitre_Fin6(){
        Histoire histoireDinoChapitre_fin6;
        histoireDinoChapitre_fin6 = new Histoire("Dino",5, R.string.chapitrefin17Dino,0,0,0,false);

        return histoireDinoChapitre_fin6;
    }

    public ArrayList<Histoire> CréationListeHistoireDino() {
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
    }
}
