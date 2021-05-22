package com.example.lombredespurges.présentation;
import android.content.Context;

import androidx.fragment.app.Fragment;
import com.example.lombredespurges.domaine.entité.AutreAventure;
import com.example.lombredespurges.modele.Modèle;

import java.util.ArrayList;

public class PrésentateurListeAventures implements IContratPrésentateurVueListeAventures.IPrésentateurListeAventures{

    private IContratPrésentateurVueListeAventures.IVueListeAventures _vue;
    private Modèle _modèle;

    public PrésentateurListeAventures(IContratPrésentateurVueListeAventures.IVueListeAventures _vue) {
        this._vue = _vue;
        _modèle = Modèle.getInstance();
    }

    @Override
    public void récupererListe() {
        Thread fil_esclave = new Thread(()->{
            ArrayList<String> listeTitlesServeur = new ArrayList<String>();
            ArrayList<String> listeTitlesBD = new ArrayList<String>();
            ArrayList<AutreAventure> listeServeur = _modèle.chercherAventuresServeur();
            ArrayList<AutreAventure> listeBD = _modèle.chercherAventuresBD();
            if(listeServeur != null) {
                for (int i = 0; i < listeServeur.size(); i++) {
                    listeTitlesServeur.add(listeServeur.get(i).getTitle());
                }
            }
            if(listeBD != null) {
                for (int i = 0; i < listeBD.size(); i++) {
                    listeTitlesBD.add(listeBD.get(i).getTitle());
                }
            }

            ( (Fragment)_vue).getActivity().runOnUiThread(()->_vue.afficherListe(listeTitlesServeur, listeTitlesBD));
        });
        fil_esclave.start();

    }

    @Override
    public Context récupererContexte() {
        return _modèle.get_ctx();
    }

    @Override
    public void sauvegarderAventure(String title) {
        _modèle.sauvegarderAventure(title);
    }

}
