package com.example.lombredespurges.présentation;
import androidx.fragment.app.Fragment;
import com.example.lombredespurges.domaine.entité.AutreAventure;
import com.example.lombredespurges.modele.Modèle;

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
            String[] tabTitles = new String[5];
            AutreAventure[] tab = _modèle.chercherAventures();
            for (int i = 0; i < tab.length ; i++) {
                tabTitles[i] = tab[i].getTitle();
            }
            ( (Fragment)_vue).getActivity().runOnUiThread(()->_vue.afficherListe(tabTitles));
        });
        fil_esclave.start();

    }

}
