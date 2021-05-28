package com.example.lombredespurges.domaine.entité;

import junit.framework.TestCase;

import java.util.ArrayList;

public class ChapitreTest extends TestCase {

    public void testGet_numéroChapitre() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        chapitre = new Chapitre(1,1,listeIdTexteChoix,listeProchainChapitre,false);
        int résultatAttendu = 1;
        int résultatObservé = chapitre.get_numéroChapitre();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void testGet_IdTexteChapitre() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        chapitre = new Chapitre(1,1,listeIdTexteChoix,listeProchainChapitre,false);
        int résultatAttendu = 1;
        int résultatObservé = chapitre.get_IdTexteChapitre();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void testGet_listeIdTexteChoix() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        chapitre = new Chapitre(1,1,listeIdTexteChoix,listeProchainChapitre,false);
        int résultatAttendu = 1;
        ArrayList<Integer> résultatObservé = chapitre.get_listeIdTexteChoix();

        assertNotNull(résultatObservé);
    }

    public void testGet_combat() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        chapitre = new Chapitre(1,1,listeIdTexteChoix,listeProchainChapitre,false);
        boolean résultatAttendu = false;
        boolean résultatObservé = chapitre.get_combat();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void testSet_combat() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        chapitre = new Chapitre(1,1,listeIdTexteChoix,listeProchainChapitre,false);
        chapitre.set_combat(true);
        boolean résultatAttendu = true;
        boolean résultatObservé = chapitre.get_combat();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void testGet_prochainChapitre() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        chapitre = new Chapitre(1,1,listeIdTexteChoix,listeProchainChapitre,false);
        Integer résultatObservé = chapitre.get_prochainChapitre(0);

        assertNotNull(résultatObservé);
    }
}