package com.example.lombredespurges.domaine.entité;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AventureTest extends TestCase {

    public void testGetChapitreCourante() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        ArrayList<Chapitre> listeChapitres = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        for (int i = 0; i < 3 ; i++) {
            chapitre = new Chapitre(i,i,listeIdTexteChoix,listeProchainChapitre,false);
            listeChapitres.add(chapitre);
        }
        Aventure aventure = new Aventure("test", listeChapitres);
        Chapitre résultatObservé = aventure.getChapitreCourante();

        assertNotNull(résultatObservé);
    }

    public void testGet_nomAventure() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        ArrayList<Chapitre> listeChapitres = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        for (int i = 0; i < 3 ; i++) {
            chapitre = new Chapitre(i,i,listeIdTexteChoix,listeProchainChapitre,false);
            listeChapitres.add(chapitre);
        }
        Aventure aventure = new Aventure("test", listeChapitres);

        String résultatAttendu = "test";
        String résultatObservé = aventure.get_nomAventure();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void testPasserAuProchainChapitre() {
        Chapitre chapitre;
        ArrayList<Integer> listeIdTexteChoix = new ArrayList<>();
        ArrayList<Integer> listeProchainChapitre = new ArrayList<>();
        ArrayList<Chapitre> listeChapitres = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listeIdTexteChoix.add(i);
            listeProchainChapitre.add(i);
        }
        for (int i = 0; i < 3 ; i++) {
            chapitre = new Chapitre(i,i,listeIdTexteChoix,listeProchainChapitre,false);
            listeChapitres.add(chapitre);
        }
        Aventure aventure = new Aventure("test", listeChapitres);
        aventure.passerAuProchainChapitre(1);
        Chapitre résultatObservé = aventure.getChapitreCourante();

        assertNotNull(résultatObservé);
    }
}