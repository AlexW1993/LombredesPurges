package com.example.lombredespurges.domaine.interacteur;


import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AventureTéléchargeable;

import java.util.ArrayList;


public class RécupérerAventure {

    /**
     * Declaration des Attributs
     */
    private SourceDeDonnées _source;

    /**
     * Constructeur de RécupérerAventure.
     */
    public RécupérerAventure(SourceDeDonnées _source) {
        this._source = _source;
    }

    /**
     * La méthode permet récupérer une  liste des aventures qui ont été sauvegarder dans une serveur.
     *
     * @return (ArrayList < AutreAventure >) la liste des aventures.
     */
    public ArrayList<AutreAventure> récupérerListeAventureServeur() {
        ArrayList<AutreAventure> listeAventures = new ArrayList<>();
        AutreAventure[] tab = _source.récupérerListeServeur();
        for (int i = 0; i < tab.length; i++) {
            listeAventures.add(tab[i]);
        }
        return listeAventures;
    }

    /**
     * La méthode permet récupérer une aventure dans une serveur.
     *
     * @return (String) l'aventure en format Json.
     */
    public String récupérerAventureServeur() {
        return _source.récupérerAventureServeur();
    }

    /**
     * La méthode permet récupérer une  liste des aventures qui ont été sauvegarder dans la BD.
     *
     * @return (ArrayList < AutreAventure >) la liste des aventures.
     */
    public ArrayList<AutreAventure> récupérerAventuresBD() {
        return _source.chercherTousAventures();
    }

    /**
     * La méthode permet récupérer une  liste des aventures qui ont été sauvegarder dans la BD avec
     * sa aevnture complète dans un chaine Json.
     *
     * @return (ArrayList < AventureTéléchargeable >) la liste des aventures.
     */
    public ArrayList<AventureTéléchargeable> récupérerAventuresTéléchargeablesBD() {
        return _source.chercherAventuresJson();
    }
}
