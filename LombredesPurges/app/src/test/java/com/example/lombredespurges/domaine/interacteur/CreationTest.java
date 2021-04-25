package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.Ennemie;
import com.example.lombredespurges.domaine.entité.Personnage;

import junit.framework.TestCase;

public class CreationTest extends TestCase {

    public void test_creation_personnage() {
        Personnage personnage = new Creation().CreationPersonnage("Link",5,5,5,5);
        Personnage résultatObservé = personnage;
        assertNotNull(résultatObservé);
    }

    public void test_creation_ennemie() {
        Ennemie ennemie = new Creation().CreationEnnemie();
        Ennemie résultatObservé = ennemie;
        assertNotNull(résultatObservé);
    }
}