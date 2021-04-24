package com.example.lombredespurges.présentation;

import java.util.ArrayList;

public class PrésentateurHistoires implements IContratPrésentateurVueHistoires.IPrésentateurHistoires {

    private IContratPrésentateurVueHistoires.IVueHistoireDino _vue;
    private Modèle _modèle;
    private ArrayList<Histoire> listeHistoireDino;

    public PrésentateurHistoires(IContratPrésentateurVueHistoires.IVueHistoireDino vue) {

        this._vue = vue;
        _modèle = Modèle.getInstance();
        listeHistoireDino = new ArrayList<Histoire>(_modèle.getListeHistoireDino());
    }

    @Override
    public void getDéterminerCombat(int positionListe) {
        boolean combat;
        combat = listeHistoireDino.get(positionListe).get_combat();
        _vue.déterminerCombat(combat);
    }

    @Override
    public void getNumeroChapitre(int positionListe) {
        int chapitre;
        chapitre = listeHistoireDino.get(positionListe).get_chapitre();
        _vue.afficherNumeroChapitre(chapitre);
    }

    @Override
    public void getTexteChapitre(int positionListe) {
        int texteChapitre;
        texteChapitre = _modèle.getListeHistoireDino().get(positionListe).get_sousChapitre();
        _vue.afficherTexteChapitre(texteChapitre);
    }

    @Override
    public void getChoix_1_Chapitre(int positionListe) {
        int choix1;
        choix1 = _modèle.getListeHistoireDino().get(positionListe).get_choix1();
        _vue.afficherChoix_1_Chapitre(choix1);
    }

    @Override
    public void getChoix_2_Chapitre(int positionListe) {
        int choix2;
        choix2 = _modèle.getListeHistoireDino().get(positionListe).get_choix2();
        _vue.afficherChoix_2_Chapitre(choix2);
    }

    @Override
    public void getChoix_3_Chapitre(int positionListe) {
        int choix3;
        choix3 = _modèle.getListeHistoireDino().get(positionListe).get_choix3();
        _vue.afficherChoix_3_Chapitre(choix3);
    }
}
