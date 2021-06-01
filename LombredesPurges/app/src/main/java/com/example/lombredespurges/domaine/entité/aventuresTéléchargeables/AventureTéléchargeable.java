package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

public class AventureTéléchargeable {

    /**
     * Declaration des Attributs
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
     * Accesseurs du chapitres courant de l'aventure
     *
     * @return (Chapters) le chapitre courant de l'aventure.
     */
    public Chapters getChapterCourant() {
        return chapterCourant;
    }

    /**
     * Mutateur du chapitres courant de l'aventure
     *
     * @param chapterCourant, le nouveau chapitre courant de l'aventure.
     */
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

    /**
     * Méthode qui permet de passer au chapitre suivant
     *
     * @param choix, le numéro du choix selectionné
     */
    public void passerAuProchainChapitreAventureTéléchargeable(int choix) {
        for (int i = 0; i < chapters.length; i++) {
            if (choix == chapters[i].getId()) {
                Chapters prochainChapitre = chapters[i];
                setChapterCourant(prochainChapitre);
            }
        }
    }

    /**
     * Méthode qui permet de revenir au premier chapire
     */
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

    /**
     * Méthode qui permet de gérer vers quel chapitre se rendre
     */
    public Chapters gestionChapitreCorant() {
        if (!aCommence) {
            this.chapterCourant = chapters[0];
            aCommence = true;
        }
        return this.chapterCourant;
    }
}