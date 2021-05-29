package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

import java.util.ArrayList;

public class Chapters {

    /**
     * Declaration des Aventure
     */
    private int id;
    private String description;
    private int[] choices;
    private String deadend;
    private String[] choices_description;
    private Combat combat;
    private Boolean avoirCombat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getChoices() {
        return choices;
    }

    public void setChoices(int[] choices) {
        this.choices = choices;
    }

    public String getDeadend() {
        return deadend;
    }

    public void setDeadend(String deadend) {
        this.deadend = deadend;
    }

    public String[] getChoices_description() {
        return choices_description;
    }

    public void setChoices_description(String[] choices_description) {
        this.choices_description = choices_description;
    }

    public Combat getCombat() {
        return combat;
    }

    public Boolean get_Combat() {
        return avoirCombat;
    }

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    /**
     * Méthode du prochain chapitre
     *
     * @param positionListe, (int) la positon du chapitre qui devrai être retrourner.
     *
     * @return (int) le numéro du prochain chapitre
     */
    public int get_prochainChapitre(int positionListe, ArrayList<Integer> _listeProchainChapitre) {

        return _listeProchainChapitre.get(positionListe);
    }
}
