package com.example.lombredespurges.source_de_données.BD;

import android.provider.BaseColumns;

public final class AventuresBDContrat {

    private AventuresBDContrat(){};

    public static final String DATABASE_NAME = "AutresAventures.bd";
    public static final int DATABASE_VERSION = 1;

    public static class TableAventure implements BaseColumns {
        public static final String NOM_TABLE = "aventure";
        public static final String COLONNE_TITLE = "title";
        public static final String COLONNE_URL = "url";
    }

    public static final String SQL_CREATE_TABLE_AVENTURE =
            "CREATE TABLE "+TableAventure.NOM_TABLE + " (" +
                    TableAventure._ID + " INTEGER PRIMARY KEY," +
                    TableAventure.COLONNE_TITLE + " VARCHER(255)," +
                    TableAventure.COLONNE_URL + " VARCHAR(255)";

    public static final String SQL_DELETE_TABLE_AVENTURE =
            "DROP TABLE IF EXISTS " + TableAventure.NOM_TABLE;

}
