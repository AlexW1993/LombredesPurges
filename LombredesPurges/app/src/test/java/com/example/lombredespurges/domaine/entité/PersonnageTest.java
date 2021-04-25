package com.example.lombredespurges.domaine.entité;

import junit.framework.TestCase;

public class PersonnageTest extends TestCase {

    public void test_chercher_nom_personnage() {
        Personnage personnageTest = new Personnage("Link", 5, 5, 5, 5);
        String résultatAttendu = "Link";
        String résultatObservé = personnageTest.get_nom();
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_force_personnage() {
        Personnage personnageTest = new Personnage("Link", 5, 5, 5, 5);
        int résultatAttendu = 5;
        int résultatObservé = personnageTest.get_force();
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_endurance_personnage() {
        Personnage personnageTest = new Personnage("Link", 5, 5, 5, 5);
        int résultatAttendu = 5;
        int résultatObservé = personnageTest.get_endurance();
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_chercher_agilité_personnage() {
        Personnage personnageTest = new Personnage("Link", 5, 5, 5, 5);
        int résultatAttendu = 5;
        int résultatObservé = personnageTest.get_agilité();
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void testGetCoefAttaque() {
    }

    public void testGetCoefDéfence() {
    }

    public void testGetDommages() {
    }

    public void test_calculer_coefficient_attaque_personnage() {
        boolean résultat = false;
        Personnage personnageTest = new Personnage("Link", 5, 5, 16, 5);
        boolean résultatObservé ;
        boolean résultatAttendu = true;

        personnageTest.calculerCoefAttaquePersonnage();
        if (personnageTest.getCoefAttaque() > 12 && personnageTest.getCoefAttaque() <= 22){
            résultat = true;
        }

        résultatObservé = résultat;
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_calculer_coefficient_défense_personnage() {
        boolean résultat = false;
        boolean résultatObservé ;
        boolean résultatAttendu = true;
        Personnage personnageTest = new Personnage("Link", 11, 23, 11, 6);
        Personnage personnage2Test = new Personnage("Mario", 16, 230, 16, 11);

        personnageTest.calculerCoefAttaquePersonnage();
        personnage2Test.calculerCoefAttaquePersonnage();
        int coefAttaqueInitial = personnageTest.getCoefAttaque();
        personnageTest.calculerCoefDéfense(personnage2Test.getCoefAttaque());
        if (coefAttaqueInitial > personnageTest.getCoefDéfence()){
            résultat = true;
        }
        résultatObservé = résultat;
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }

    public void test_calculer_recevoir_dommage() {
        boolean résultat = false;
        boolean résultatObservé;
        boolean résultatAttendu = true;
        Personnage personnageTest = new Personnage("Link", 11, 23, 11, 6);
        Personnage personnage2Test = new Personnage("Mario", 16, 230, 16, 11);
        int enduranceInitial = personnageTest.get_endurance();
        int forceAttaquant = personnage2Test.get_force();

        personnageTest.calculerCoefAttaquePersonnage();
        personnage2Test.calculerCoefAttaquePersonnage();
        personnageTest.calculerCoefDéfense(personnage2Test.getCoefAttaque());
        personnageTest.calculerEtRecevoirDommage(forceAttaquant);
        if (enduranceInitial > personnageTest.get_endurance()){
            résultat = true;
        }
        résultatObservé = résultat;
        assertNotNull(résultatObservé);
        assertEquals(résultatAttendu, résultatObservé);
    }
}