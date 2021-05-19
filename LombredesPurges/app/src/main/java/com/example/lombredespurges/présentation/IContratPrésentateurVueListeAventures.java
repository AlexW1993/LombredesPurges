package com.example.lombredespurges.présentation;


public interface IContratPrésentateurVueListeAventures {

    public interface IPrésentateurListeAventures{
        public void récupererListe();

    }

    public interface IVueListeAventures{
        public void afficherListe(String[] tab);
    }
}
