package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.R;
import com.example.lombredespurges.domaine.entité.Aventure;
import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;

import java.util.ArrayList;
import java.util.Random;

public class Creation {

    /**
     * La méthode permet la creation d'un personnage.
     *
     * @param (nom,force,edurance,agilité,intelligence), le nom du personnage avec ses attributs.
     * @return (Personnage) le personnage créé.
     */
    public Personnage CreationPersonnage(String nom, int force, int endurance, int agilité, int intelligence) {
        Personnage personnage = new Personnage(nom, force, endurance, agilité, intelligence);
        return personnage;
    }

    /**
     * La méthode permet la creation d'un ennemie.
     *
     * @return (Ennemi) l'ennemi créé.
     */
    public Ennemie CreationEnnemie() {
        Ennemie ennemie;
        int num, force, endurence, agilité, intelligence;
        num = new Random().nextInt((3 - 1) + 1) + 1;
        force = 10 + num;
        num = new Random().nextInt((7 - 1) + 1) + 1;
        endurence = 20 + (2 * num);
        num = new Random().nextInt((3 - 1) + 1) + 1;
        agilité = 10 + num;
        num = new Random().nextInt((3 - 1) + 1) + 1;
        intelligence = 5 + num;
        ennemie = new Ennemie("Purge", force, endurence, agilité, intelligence);
        return ennemie;
    }

    /**
     * La méthode permet la creation d'un liste d'aventure.
     *
     * @return (listeAventures) la liste d'aventures.
     */
    public ArrayList<Aventure> CréationJeu() {
        ArrayList<Aventure> listeAventures = new ArrayList<Aventure>();
        listeAventures.add(CréationAventureDino());
        listeAventures.add(CréationAventureVia());
        listeAventures.add(CréationAventureKachikam());
        return listeAventures;
    }

    /**
     * La méthode permet la creation de l'aventure de Dino.
     *
     * @return (dino) l'aventure de dino.
     */
    private Aventure CréationAventureDino() {
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

        Aventure dino = new Aventure("Dino", listeChapitres);

        return dino;
    }

    /**
     * La méthode permet la creation de l'aventure de Via.
     *
     * @return (via) l'aventure de Via.
     */
    private Aventure CréationAventureVia() {
        ArrayList<Chapitre> listeChapitres = new ArrayList<Chapitre>();
        listeChapitres.add(CréationHistoireViaChapitre0());
        listeChapitres.add(CréationHistoireViaChapitre1());
        listeChapitres.add(CréationHistoireViaChapitre2());
        listeChapitres.add(CréationHistoireViaChapitre3());
        listeChapitres.add(CréationHistoireViaChapitre4());
        listeChapitres.add(CréationHistoireViaChapitre5());
        listeChapitres.add(CréationHistoireViaChapitre6());
        listeChapitres.add(CréationHistoireViaChapitre7());
        listeChapitres.add(CréationHistoireViaChapitre8());
        listeChapitres.add(CréationHistoireViaChapitre9());
        listeChapitres.add(CréationHistoireViaChapitre10());
        listeChapitres.add(CréationHistoireViaChapitre11());
        listeChapitres.add(CréationHistoireViaChapitre12());
        listeChapitres.add(CréationHistoireViaChapitre13());
        listeChapitres.add(CréationHistoireViaChapitre14());
        listeChapitres.add(CréationHistoireViaChapitre15());
        listeChapitres.add(CréationHistoireViaChapitre16());
        listeChapitres.add(CréationHistoireViaChapitre17());

        Aventure via = new Aventure("Via", listeChapitres);

        return via;
    }

    /**
     * La méthode permet la creation de l'aventure de Kachikam.
     *
     * @return (kachikam) l'aventure de kachikam.
     */
    private Aventure CréationAventureKachikam() {
        ArrayList<Chapitre> listeChapitres = new ArrayList<Chapitre>();
        listeChapitres.add(CréationHistoireKachikamChapitre0());
        listeChapitres.add(CréationHistoireKachikamChapitre1());
        listeChapitres.add(CréationHistoireKachikamChapitre2());
        listeChapitres.add(CréationHistoireKachikamChapitre3());
        listeChapitres.add(CréationHistoireKachikamChapitre4());
        listeChapitres.add(CréationHistoireKachikamChapitre5());
        listeChapitres.add(CréationHistoireKachikamChapitre6());
        listeChapitres.add(CréationHistoireKachikamChapitre7());
        listeChapitres.add(CréationHistoireKachikamChapitre8());
        listeChapitres.add(CréationHistoireKachikamChapitre9());
        listeChapitres.add(CréationHistoireKachikamChapitre10());
        listeChapitres.add(CréationHistoireKachikamChapitre11());
        listeChapitres.add(CréationHistoireKachikamChapitre12());
        listeChapitres.add(CréationHistoireKachikamChapitre13());
        listeChapitres.add(CréationHistoireKachikamChapitre14());
        listeChapitres.add(CréationHistoireKachikamChapitre15());
        listeChapitres.add(CréationHistoireKachikamChapitre16());
        listeChapitres.add(CréationHistoireKachikamChapitre17());

        Aventure Kachikam = new Aventure("Kachikam", listeChapitres);

        return Kachikam;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 0 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre0() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix0_1);
        listeChoix.add(R.string.choix0_2);
        listeChoix.add(R.string.choix0_3);
        listeProchain.add(1);
        listeProchain.add(2);
        listeProchain.add(3);

        chapitre = new Chapitre(0, R.string.chapitre0Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 1 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre1() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix1_1);
        listeChoix.add(R.string.choix1_2);
        listeChoix.add(R.string.choix1_3);
        listeProchain.add(4);
        listeProchain.add(5);
        listeProchain.add(6);

        chapitre = new Chapitre(1, R.string.chapitre1Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 2 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre2() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix2_1);
        listeChoix.add(R.string.choix2_2);
        listeChoix.add(R.string.choix2_3);
        listeProchain.add(4);
        listeProchain.add(5);
        listeProchain.add(6);
        chapitre = new Chapitre(2, R.string.chapitre2Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 3 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre3() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix3_1);
        listeChoix.add(R.string.choix3_2);
        listeChoix.add(R.string.choix3_3);
        listeProchain.add(9);
        listeProchain.add(8);
        listeProchain.add(7);
        chapitre = new Chapitre(3, R.string.chapitre3Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 4 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre4() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix4_1);
        listeChoix.add(R.string.choix4_2);
        listeChoix.add(R.string.choix4_3);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(4, R.string.chapitre4Dino, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 5 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre5() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix5_1);
        listeChoix.add(R.string.choix5_2);
        listeChoix.add(R.string.choix5_3);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(5, R.string.chapitre5Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 6 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre6() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        chapitre = new Chapitre(6, R.string.chapitre6Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 7 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre7() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(7, R.string.chapitre7Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 8 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre8() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix8_1);
        listeChoix.add(R.string.choix8_2);
        listeChoix.add(R.string.choix8_3);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(8, R.string.chapitre8Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 9 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre9() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix9_1);
        listeChoix.add(R.string.choix9_2);
        listeChoix.add(R.string.choix9_3);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(9, R.string.chapitre9Dino, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 10 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre10() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix10_1);
        listeChoix.add(R.string.choix10_2);
        listeChoix.add(R.string.choix10_3);
        listeProchain.add(15);
        listeProchain.add(13);
        listeProchain.add(14);
        chapitre = new Chapitre(10, R.string.chapitre10Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 11 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre11() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix11_1);
        listeChoix.add(R.string.choix11_2);
        listeChoix.add(R.string.choix11_3);
        listeProchain.add(16);
        listeProchain.add(17);
        listeProchain.add(18);
        chapitre = new Chapitre(11, R.string.chapitre11Dino, listeChoix, listeProchain, false);

        return chapitre;
    }


    /**
     * La méthode permet la creation de la histoire du chapitre 12 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre12() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(12, R.string.chapitre12Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 13 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre13() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(13, R.string.chapitre13Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 14 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre14() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(14, R.string.chapitre14Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 15 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre15() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(15, R.string.chapitre15Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 16 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre16() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(16, R.string.chapitre16Dino, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 17 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre17() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(17, R.string.chapitre17Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 18 de Dino
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireDinoChapitre18() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(18, R.string.chapitre18Dino, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 0 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre0() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix0_1);
        listeChoix.add(R.string.choix0_2);
        listeChoix.add(R.string.choix0_3);
        listeProchain.add(1);
        listeProchain.add(2);
        listeProchain.add(3);

        chapitre = new Chapitre(0, R.string.chapitre0Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 1 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre1() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix1_1);
        listeChoix.add(R.string.choix1_2);
        listeChoix.add(R.string.choix1_3);
        listeProchain.add(4);
        listeProchain.add(5);
        listeProchain.add(6);

        chapitre = new Chapitre(1, R.string.chapitre1Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 2 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre2() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix2_1);
        listeChoix.add(R.string.choix2_2);
        listeChoix.add(R.string.choix2_3);
        listeProchain.add(4);
        listeProchain.add(5);
        listeProchain.add(6);
        chapitre = new Chapitre(2, R.string.chapitre2Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 3 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre3() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix3_1);
        listeChoix.add(R.string.choix3_2);
        listeChoix.add(R.string.choix3_3);
        listeProchain.add(9);
        listeProchain.add(8);
        listeProchain.add(7);
        chapitre = new Chapitre(3, R.string.chapitre3Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 4 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre4() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix4_1);
        listeChoix.add(R.string.choix4_2);
        listeChoix.add(R.string.choix4_3);
        listeProchain.add(10);
        listeProchain.add(11);
        listeProchain.add(12);
        chapitre = new Chapitre(4, R.string.chapitre4Via, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 5 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre5() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix5_1);
        listeChoix.add(R.string.choix5_2);
        listeChoix.add(R.string.choix5_3);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(5, R.string.chapitre5Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 6 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre6() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        chapitre = new Chapitre(6, R.string.chapitre6Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 7 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre7() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(7, R.string.chapitre7Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 8 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre8() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix8_1);
        listeChoix.add(R.string.choix8_2);
        listeChoix.add(R.string.choix8_3);
        listeProchain.add(10);
        listeProchain.add(11);
        listeProchain.add(12);
        chapitre = new Chapitre(8, R.string.chapitre8Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 9 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre9() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix9_1);
        listeChoix.add(R.string.choix9_2);
        listeChoix.add(R.string.choix9_3);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(9, R.string.chapitre9Via, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 10 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre10() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix10_1);
        listeChoix.add(R.string.choix10_2);
        listeChoix.add(R.string.choix10_3);
        listeProchain.add(15);
        listeProchain.add(13);
        listeProchain.add(14);
        chapitre = new Chapitre(10, R.string.chapitre10Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 11 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre11() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix11_1);
        listeChoix.add(R.string.choix11_2);
        listeChoix.add(R.string.choix11_3);
        listeProchain.add(16);
        listeProchain.add(13);
        listeProchain.add(17);
        chapitre = new Chapitre(11, R.string.chapitre11Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 12 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre12() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(12, R.string.chapitre12Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 13 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre13() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(13, R.string.chapitre13Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 14 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre14() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(14, R.string.chapitre14Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 15 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre15() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(15, R.string.chapitre15Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 16 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre16() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(16, R.string.chapitre16Via, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 17 de Via
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireViaChapitre17() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(17, R.string.chapitre17Via, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 0 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre0() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix0_1Kachikam);
        listeChoix.add(R.string.choix0_2Kachikam);
        listeChoix.add(R.string.choix0_3Kachikam);
        listeProchain.add(1);
        listeProchain.add(2);
        listeProchain.add(3);

        chapitre = new Chapitre(0, R.string.chapitre0Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 1 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre1() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix1_1Kachikam);
        listeChoix.add(R.string.choix1_2Kachikam);
        listeChoix.add(R.string.choix1_3Kachikam);
        listeProchain.add(4);
        listeProchain.add(5);
        listeProchain.add(7);

        chapitre = new Chapitre(1, R.string.chapitre1Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 2 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre2() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix2_1Kachikam);
        listeChoix.add(R.string.choix2_2Kachikam);
        listeChoix.add(R.string.choix2_3Kachikam);
        listeProchain.add(4);
        listeProchain.add(5);
        listeProchain.add(6);
        chapitre = new Chapitre(2, R.string.chapitre2Kachikam, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 3 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre3() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix3_1Kachikam);
        listeChoix.add(R.string.choix3_2Kachikam);
        listeChoix.add(R.string.choix3_3Kachikam);
        listeProchain.add(9);
        listeProchain.add(8);
        listeProchain.add(7);
        chapitre = new Chapitre(3, R.string.chapitre3Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 4 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre4() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix4_1Kachikam);
        listeChoix.add(R.string.choix4_2Kachikam);
        listeChoix.add(R.string.choix4_3Kachikam);
        listeProchain.add(9);
        listeProchain.add(8);
        listeProchain.add(7);
        chapitre = new Chapitre(4, R.string.chapitre4Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 5 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre5() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix5_1Kachikam);
        listeChoix.add(R.string.choix5_2Kachikam);
        listeChoix.add(R.string.choix5_3Kachikam);
        listeProchain.add(9);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(5, R.string.chapitre5Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 6 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre6() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        chapitre = new Chapitre(6, R.string.chapitre6Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  du chapitre 7 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre7() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(7, R.string.chapitre7Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 8 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre8() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix8_1Kachikam);
        listeChoix.add(R.string.choix8_2Kachikam);
        listeChoix.add(R.string.choix8_3Kachikam);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(8, R.string.chapitre8Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 9 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre9() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix9_1Kachikam);
        listeChoix.add(R.string.choix9_2Kachikam);
        listeChoix.add(R.string.choix9_3Kachikam);
        listeProchain.add(12);
        listeProchain.add(10);
        listeProchain.add(11);
        chapitre = new Chapitre(9, R.string.chapitre9Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 10 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre10() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix10_1Kachikam);
        listeChoix.add(R.string.choix10_2Kachikam);
        listeChoix.add(R.string.choix10_3Kachikam);
        listeProchain.add(15);
        listeProchain.add(13);
        listeProchain.add(17);
        chapitre = new Chapitre(10, R.string.chapitre10Kachikam, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire  et la liste de choix du chapitre 11 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre11() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre;
        listeChoix.add(R.string.choix11_1Kachikam);
        listeChoix.add(R.string.choix11_2Kachikam);
        listeChoix.add(R.string.choix11_3Kachikam);
        listeProchain.add(15);
        listeProchain.add(16);
        listeProchain.add(17);
        chapitre = new Chapitre(11, R.string.chapitre11Kachikam, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 12 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre12() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(12, R.string.chapitre12Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 13 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre13() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(13, R.string.chapitre13Kachikam, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 14 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre14() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(14, R.string.chapitre14Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 15 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre15() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(15, R.string.chapitre15Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 16 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre16() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(16, R.string.chapitre16Kachikam, listeChoix, listeProchain, true);

        return chapitre;
    }

    /**
     * La méthode permet la creation de la histoire du chapitre 17 de Kachikam
     *
     * @return (chapitre) le chapitre qui a été créé.
     */
    private Chapitre CréationHistoireKachikamChapitre17() {
        ArrayList<Integer> listeChoix = new ArrayList<Integer>();
        ArrayList<Integer> listeProchain = new ArrayList<Integer>();
        Chapitre chapitre = new Chapitre(17, R.string.chapitre17Kachikam, listeChoix, listeProchain, false);

        return chapitre;
    }
}
