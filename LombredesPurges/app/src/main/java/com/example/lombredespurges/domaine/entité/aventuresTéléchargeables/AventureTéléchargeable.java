package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

import java.util.ArrayList;

public class AventureTéléchargeable {
    /**
     * Declaration des Aventure
     */
    private String title;
    private Chapters [] chapters;
    private Chapters chapitreCourante;
    /**
     * Accesseurs du title de l'aventure
     *
     * @return (String) le title de l'aventure.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Mutateur de title
     *
     * @param title, le title de l'aventure
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accesseurs du tableau de chapitres de l'aventure
     *
     * @return (Chapters[]) le tableau de chapitres de l'aventure.
     */
    public Chapters[] getChapters() {
        return chapters;
    }

    /**
     * Mutateur de title
     *
     * @param chapters, le tableua avec les chapitres d'une aventure.
     */
    public void setChapters(Chapters [] chapters) {
        this.chapters = chapters;
    }

    /**
     * Accesseurs du chapitre courante
     *
     * @return (Chapitre) le chapitre Courante.
     */
    public Chapters getChapitreCourant(){
        return chapitreCourante;
    }

    /**
     * Méthode qui ajouete le prochaine chapitre dans le chapitreCourante.
     *
     * @param choix, (int) la choix que le joueur à fait pour continuer l'aventure.
     */
    public void passerAuProchainChapitre(int choix, ArrayList<AventureTéléchargeable> _listeAventuresTéléchargeableBD){

        int prochainChapitre = chapitreCourante.getChoices()[choix];

        chapitreCourante = _listeAventuresTéléchargeableBD.get(prochainChapitre).getChapitreCourant();
    }
}
