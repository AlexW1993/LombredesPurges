package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

import java.util.ArrayList;

public class AventureTéléchargeable {
    /**
     * Declaration des Aventure
     */
    private String title;
    private Chapters[] chapters;
    private Chapters chapterCourant;
    private boolean aCommence;

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

    public Chapters getChapterCourant() {
        return chapterCourant;
    }

    public void setChapterCourant(Chapters chapterCourant) {
        this.chapterCourant = chapterCourant;
    }

    /**
     * Mutateur de title
     *
     * @param chapters, le tableau avec les chapitres d'une aventure.
     */
    public void setChapters(Chapters[] chapters) {
        this.chapters = chapters;
    }

    public void passerAuProchainChapitreAventureTéléchargeable(int choix) {
        for (int i = 0; i < chapters.length; i++) {
            if (choix == chapters[i].getId()) {
                Chapters prochainChapitre = chapters[i];
                setChapterCourant(prochainChapitre);
            }
        }
    }

    public void reinitialiserAvantureTelechargeable() {
        chapterCourant = chapters[0];
        for (Chapters unChapitre : chapters) {
            if (unChapitre.getCombats() != null) {
                for (Combats unCombat : unChapitre.getCombats()) {
                    unCombat.setTerminé(false);
                }
            }
        }
    }

    public Chapters gestionChapitreCorant() {
        if (!aCommence) {
            this.chapterCourant = chapters[0];
            aCommence = true;
        }
        return this.chapterCourant;
    }
}