package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.modele.Modèle;

import junit.framework.TestCase;

public class ModèleTest extends TestCase {

    public void test_chercher_Instance_modèle() {
        Modèle modèle = Modèle.getInstance();
        Modèle résultatObservé = modèle;
        assertNotNull(résultatObservé);
    }

    public void test_creation_et_chercher_personnage() {
        Modèle modèle = Modèle.getInstance();
        modèle.creationPersonnage("Link",5,5,5,5);
        Personnage résultatObservé = modèle.getPersonnage();
        assertNotNull(résultatObservé);
    }

    public void test_creation_et_chercher_ennemie() {
        Modèle modèle = Modèle.getInstance();
        modèle.creationEnnemie();
        Ennemie résultatObservé = modèle.getEnnemie();
        assertNotNull(résultatObservé);
    }

    public void test_chercher_même_personnage() {
        Modèle modèle = Modèle.getInstance();
        modèle.creationPersonnage("Link",5,5,5,5);
        Personnage résultatObservé = modèle.getPersonnage();
        Personnage résultatAttendu = modèle.getPersonnage();
        assertEquals(résultatAttendu,résultatObservé);
    }

    public void test_chercher_même_Ennemie() {
        Modèle modèle = Modèle.getInstance();
        modèle.creationEnnemie();
        Ennemie résultatObservé = modèle.getEnnemie();
        Ennemie résultatAttendu = modèle.getEnnemie();
        assertEquals(résultatAttendu,résultatObservé);
    }

    public void test_calculer_coef_attaque() {
        Modèle modèle = Modèle.getInstance();
        modèle.creationPersonnage("Link",5,5,5,5);
        modèle.creationEnnemie();
        modèle.calculerCoefAttaque();
        boolean résultatPersonnage;
        boolean résultatEnnemie;
        int coefficientAttaquePersonnage = modèle.getPersonnage().getCoefAttaque();
        int coefficientAttaqueEnnemie = modèle.getEnnemie().getCoefAttaque();
        if (coefficientAttaquePersonnage > 5 && coefficientAttaquePersonnage < 12){
            résultatPersonnage = true;
        } else {
            résultatPersonnage = false;
        }
        if (coefficientAttaqueEnnemie > 11 && coefficientAttaqueEnnemie < 20){
            résultatEnnemie = true;
        } else {
            résultatEnnemie = false;
        }
        boolean résultatAttendu = true;
        boolean résultatObservé;
        if(résultatPersonnage == true && résultatEnnemie == true){
            résultatObservé = true;
        } else {
            résultatObservé = false;
        }
        assertEquals(résultatAttendu,résultatObservé);
    }

    public void test_comparaison_coef_attaque() {
        Modèle modèle = Modèle.getInstance();
        modèle.creationPersonnage("Link",5,5,5,5);
        modèle.creationEnnemie();
        modèle.calculerCoefAttaque();
        boolean résultatObservé = modèle.comparaisonCoefAttaque();
        assertNotNull(résultatObservé);
    }
}