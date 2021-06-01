package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

public class Chapters {

    /**
     * Declaration des Attributs
     */
    private int id;
    private String description;
    private int[] choices;
    private String deadend;
    private String[] choices_description;
    private Combats[] combats;

    /**
     * Accesseurs du id de l'aventure
     *
     * @return (int) Le id du chapitre
     */
    public int getId() {
        return id;
    }

    /**
     * Mutateur du id
     *
     * @param id, le nouvel id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Accesseurs du contenu du chapitre
     *
     * @return (String) le contenu du chapitre
     */
    public String getDescription() {
        return description;
    }

    /**
     * Accesseurs de la liste des choix
     *
     * @return (String) la liste des choix
     */
    public int[] getChoices() {
        return choices;
    }

    /**
     * Accesseurs du contenu de la fin
     *
     * @return (String) le contenu de la fin
     */
    public String getDeadend() {
        return this.deadend;
    }

    /**
     * Accesseurs de la liste du contenu des choix
     *
     * @return (String) la liste du contenu des choix
     */
    public String[] getChoices_description() {
        return choices_description;
    }

    /**
     * Accesseurs de la liste des combats
     *
     * @return (String) la liste des combats
     */
    public Combats[] getCombats() {
        return combats;
    }

}
