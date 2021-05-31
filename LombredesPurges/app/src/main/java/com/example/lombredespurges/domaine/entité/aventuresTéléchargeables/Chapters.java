package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

import com.example.lombredespurges.domaine.entité.Ennemie;

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
    private Combats[] combats;

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

    public String getDeadend() {
        return this.deadend;
    }

    public void setDeadend(String deadend) {
        this.deadend = deadend;
    }

    public String[] getChoices_description() {
        return choices_description;
    }

    public Combats[] getCombats() {
        return combats;
    }

}
