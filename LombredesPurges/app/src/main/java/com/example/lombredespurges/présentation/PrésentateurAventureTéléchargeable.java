package com.example.lombredespurges.présentation;

import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.Chapters;
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
     *
     */
    @Override
    public void gestionChapitre(int choix) {
        if(choix != -1){
            _modèle.passerAuProchainChapitre(choix);
        }

        Chapters unChapitre = _modèle.commencement();

        if(unChapitre.get_Combat()){
            _vue.passerAuCombat();
        }

        int numChapitre = unChapitre.getId();
        String idContenueChapitre = unChapitre.getDescription();
        String[] listeIdChoix = unChapitre.getChoices_description();
        String nomPersonnage = _modèle.getPersonnage().get_nom();

        if(listeIdChoix.length == 0){
            _vue.afficherFinJeu(nomPersonnage, idContenueChapitre);
        }else{
            String choix1 = listeIdChoix[0];
            String choix2 = listeIdChoix[1];
            String choix3 = listeIdChoix[2];

            _vue.afficherAventure(numChapitre, idContenueChapitre, choix1, choix2, choix3);
        }
    }

    /**
     * La méthode permet de reinitalise le jeu. (réinitialiser la liste de chapitres et afficher la page de titre.)
     *
     */
    @Override
    public void réinitialierJeu() {
        _modèle.réanitialierJeu();
        _vue.passerPageTitre();
    }


}
