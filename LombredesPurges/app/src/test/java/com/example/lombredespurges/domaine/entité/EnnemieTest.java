package com.example.lombredespurges.domaine.entité;

import junit.framework.TestCase;

public class EnnemieTest extends TestCase {

    public void testGet_nom() {
        Ennemie ennemieTest = new Ennemie("Gustave", 11, 23, 11, 6);
        String nomEnnemie = ennemieTest.get_nom();
        assertNotNull(ennemieTest);
        assertEquals("Gustave", nomEnnemie);

    }

    public void testGet_force() {
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        int forceEnnemie = ennemieTest.get_force();
        assertNotNull(ennemieTest);
        assertEquals(16, forceEnnemie);

    }

    public void testGet_endurance() {
        Ennemie ennemieTest = new Ennemie("Gustave", 11, 23, 11, 6);
        int enduranceEnnemie = ennemieTest.get_force();
        assertNotNull(ennemieTest);
        assertEquals(11, enduranceEnnemie);

    }

    public void testGet_agilité() {
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);
        int agiliteEnnemie = ennemieTest.get_force();
        assertNotNull(ennemieTest);
        assertEquals(16, agiliteEnnemie);

    }

    public void testGetCoefAttaque() {
    }

    public void testGetCoefDéfence() {
    }

    public void testGetDommages() {
    }

    public void testCalculerCoefAttaqueEnnemi() {
        boolean resultat = false;
        Ennemie ennemieTest = new Ennemie("Gustave", 16, 230, 16, 11);

        ennemieTest.calculerCoefAttaqueEnnemi();
        if (ennemieTest.getCoefAttaque() > 12 && ennemieTest.getCoefAttaque() <= 22){
            resultat = true;
        }

        assertEquals(true, resultat);

    }

    public void testCalculerCoefDéfense() {
    }

    public void testCalculerEtRecevoirDommage() {
        boolean resultat = false;
        Ennemie ennemieTest = new Ennemie("Gustave", 11, 23, 11, 6);
        Ennemie ennemie2Test = new Ennemie("Gustave", 16, 230, 16, 11);
        int enduranceInitial = ennemieTest.get_endurance();
        int forceAttaquant = ennemie2Test.get_force();
        ennemieTest.calculerCoefAttaqueEnnemi();
        ennemie2Test.calculerCoefAttaqueEnnemi();
        ennemieTest.calculerCoefDéfense(ennemie2Test.getCoefAttaque());
        ennemieTest.calculerEtRecevoirDommage(forceAttaquant);
        if (enduranceInitial > ennemieTest.get_endurance()){
            resultat = true;
        }
        assertEquals(true, resultat);
    }
}