package com.example.lombredespurges.domaine.interacteur;

import com.example.lombredespurges.domaine.entité.AutreAventure;


public interface SourceDeDonnées {
    public void enregistrer(  );
    public AutreAventure[] récupérer( );
}
