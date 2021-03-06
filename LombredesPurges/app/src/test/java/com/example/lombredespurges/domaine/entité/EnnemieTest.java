package com.example.lombredespurges.domaine.entité;

import junit.framework.TestCase;

public class EnnemieTest extends TestCase {

    public void test_chercher_nom_ennemi() {
        Ennemie ennemieTest = new Ennemie("Gustave", 11, 23, 11, 6);
        String résultatAttendu = "Gustave";
        String résultatObservé = ennemieTest.get_nom();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_force_ennemi() {
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        int résultatAttendu = 16;
        int résultatObservé = ennemieTest.get_force();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_endurance_ennemi() {
        Ennemie ennemieTest = new Ennemie("Gustave", 11, 23, 11, 6);
        int résultatAttendu = 23;
        int résultatObservé = ennemieTest.get_endurance();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_agilité_ennemi() {
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        int résultatAttendu = 16;
        int résultatObservé = ennemieTest.get_agilité();

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_Coefficient_Attaque_ennemi() {
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        boolean résultat = false;
        int résultatCoefAvantCalcul = ennemieTest.getCoefAttaque();
        boolean résultatAttendu = true;
        boolean résultatObservé;


        ennemieTest.calculerCoefAttaqueEnnemi();

        int résultatCoefAprèsCalcul = ennemieTest.getCoefAttaque();

        if(résultatCoefAvantCalcul < résultatCoefAprèsCalcul){
            résultat = true;
        }

        résultatObservé = résultat;

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_Coefficient_Défense_ennemi() {
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        Ennemie ennemie2Test = new Ennemie("Gustave", 16, 230, 16, 11);
        boolean résultat = false;
        int résultatCoefAvantCalcul = ennemie2Test.getCoefDéfence();
        boolean résultatAttendu = true;
        boolean résultatObservé;

        ennemieTest.calculerCoefAttaqueEnnemi();
        ennemie2Test.calculerCoefDéfense(ennemieTest.getCoefAttaque());

        int résultatCoefAprèsCalcul = ennemie2Test.getCoefDéfence();

        if(résultatCoefAvantCalcul < résultatCoefAprèsCalcul){
            résultat = true;
        }

        résultatObservé = résultat;

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_Dommage_ennemi() {
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        Ennemie ennemie2Test = new Ennemie("Gustave", 16, 230, 16, 11);
        boolean résultat = false;
        int résultatCoefAvantCalcul = ennemie2Test.getDommages();
        boolean résultatAttendu = true;
        boolean résultatObservé;

        ennemieTest.calculerCoefAttaqueEnnemi();
        ennemie2Test.calculerCoefDéfense(ennemieTest.getCoefAttaque());
        ennemie2Test.calculerEtRecevoirDommage(ennemie2Test.get_force());

        int résultatDommagesAprèsCalcul = ennemie2Test.getDommages();

        if(résultatCoefAvantCalcul < résultatDommagesAprèsCalcul){
            résultat = true;
        }

        résultatObservé = résultat;

        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }


    public void test_Calculer_Coefficient_Attaque_Ennemi() {
        boolean résultat = false;
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        boolean résultatAttendu = true;
        boolean résultatObservé;

        ennemieTest.calculerCoefAttaqueEnnemi();
        if (ennemieTest.getCoefAttaque() > 12 && ennemieTest.getCoefAttaque() <= 22){
            résultat = true;
        }

        résultatObservé = résultat;
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_Calculer_Coefficient_Défense_ennemi() {
        boolean résultat = false;
        boolean résultatObservé;
        boolean résultatAttendu = true;
        Ennemie ennemieTest = new Ennemie("Gustave", 11, 23, 11, 6);
        Ennemie ennemie2Test = new Ennemie("Gustave", 16, 230, 16, 11);

        ennemieTest.calculerCoefAttaqueEnnemi();
        ennemie2Test.calculerCoefAttaqueEnnemi();
        int coefAttaqueInitial = ennemieTest.getCoefAttaque();
        ennemieTest.calculerCoefDéfense(ennemie2Test.getCoefAttaque());
        if (coefAttaqueInitial > ennemieTest.getCoefDéfence()){
            résultat = true;
        }
        résultatObservé = résultat;
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);

    }

    public void test_Calculer_Recevoir_Dommage() {
        boolean résultat = false;
        boolean résultatObservé;
        boolean résultatAttendu = true;
        Ennemie ennemieTest = new Ennemie("Gustave", 11, 23, 11, 6);
        Ennemie ennemie2Test = new Ennemie("Gustave", 16, 230, 16, 11);
        int enduranceInitial = ennemieTest.get_endurance();
        int forceAttaquant = ennemie2Test.get_force();

        ennemieTest.calculerCoefAttaqueEnnemi();
        ennemie2Test.calculerCoefAttaqueEnnemi();
        ennemieTest.calculerCoefDéfense(ennemie2Test.getCoefAttaque());
        ennemieTest.calculerEtRecevoirDommage(forceAttaquant);
        if (enduranceInitial > ennemieTest.get_endurance()){
            résultat = true;
        }
        résultatObservé = résultat;
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }
}