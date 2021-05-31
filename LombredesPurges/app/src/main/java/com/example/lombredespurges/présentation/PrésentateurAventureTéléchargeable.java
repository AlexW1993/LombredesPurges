package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.Chapters;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.Combats;
import com.example.lombredespurges.modele.Modèle;

public class PrésentateurAventureTéléchargeable implements IContratPrésentateurVueAventureTéléchargeable.IPrésentateurAventureTéléchargeable {
    /**
     * Declaration des Attributs
     */
    private IContratPrésentateurVueAventureTéléchargeable.IVueAventureTéléchargeable _vue;
    private Modèle _modèle;

    /**
     * Constructeur du presentateur du creationPersonnage.
     *
     * @param vue, la vue Histoire.
     */
    public PrésentateurAventureTéléchargeable(IContratPrésentateurVueAventureTéléchargeable.IVueAventureTéléchargeable vue) {
        this._vue = vue;
        _modèle = Modèle.getInstance();
    }

    /**
     * La méthode cherhcer les information pour le chapitre..
     */
    @Override
    public void gestionChapitre(int choix) {
        if (choix != -1) {
            _modèle.passerAuProchainChapitreAventureTéléchargeable(choix);
        }

        Chapters unChapitre = _modèle.gestionChapitreCorant();

        if (unChapitre.getCombats() != null) {
            for (Combats unCombat : unChapitre.getCombats()) {
                if (!unCombat.isTerminé()) {
                    _vue.passerAuCombat();
                }
            }
        }

        int numChapitre = unChapitre.getId();
        String contenueChapitre = unChapitre.getDescription();
        String finChapitre = unChapitre.getDeadend();
        int[] listeChoix = unChapitre.getChoices();
        String[] descriptionChoix = unChapitre.getChoices_description();
        String nomPersonnage = _modèle.getPersonnage().get_nom();

        if (listeChoix == null) {
            _vue.afficherFinJeu(finChapitre, contenueChapitre);
        }

        if (unChapitre.getDeadend() == null) {
            _vue.afficherAventure(numChapitre, contenueChapitre, listeChoix, descriptionChoix, _modèle.get_contexte());
        }
    }

    /**
     * La méthode permet de reinitalise le jeu. (réinitialiser la liste de chapitres et afficher la page de titre.)
     */
    @Override
    public void réinitialierJeu() {
        _modèle.reinitialiserAvantureTelechargeable();
        _vue.passerPageTitre();
    }
}
