package com.example.lombredespurges.présentation;


import android.content.Context;

import java.util.ArrayList;

public interface IContratPrésentateurVueListeAventures {

    public interface IPrésentateurListeAventures {
        public void récupererListe();

        public Context récupererContexte();

        public void sauvegarderAventure(String title);

        public void aventureÀJouer(String title);

    }

    public interface IVueListeAventures {
        public void afficherListe(ArrayList<String> listeServeur, ArrayList<String> listeBD);
    }
}
