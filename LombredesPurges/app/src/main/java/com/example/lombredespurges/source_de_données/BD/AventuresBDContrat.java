package com.example.lombredespurges.source_de_données.BD;

import android.provider.BaseColumns;

public final class AventuresBDContrat {

    private AventuresBDContrat(){};

    public static final String DATABASE_NAME = "AutresAventures.bd";
    public static final int DATABASE_VERSION = 3;

    public static class TableAventures implements BaseColumns {
        public static final String NOM_TABLE = "aventures";
        public static final String COLONNE_TITLE = "title";
        public static final String COLONNE_URL = "url";
    }

    public static class TableAventuresJson implements BaseColumns {
        public static final String NOM_TABLE = "aventures_json";
        public static final String COLONNE_TITLE = "title";
        public static final String COLONNE_JSON = "json";
    }

    public static final String SQL_CREATE_TABLE_AVENTURE =
            "CREATE TABLE "+ TableAventures.NOM_TABLE + " (" +
                    TableAventures._ID + " INTEGER PRIMARY KEY," +
                    TableAventures.COLONNE_TITLE + " TEXT," +
                    TableAventures.COLONNE_URL + " TEXT )";

    public static final String SQL_CREATE_TABLE_AVENTURE_JSON =
            "CREATE TABLE "+ TableAventuresJson.NOM_TABLE + " (" +
                    TableAventuresJson._ID + " INTEGER PRIMARY KEY," +
                    TableAventuresJson.COLONNE_TITLE + " TEXT," +
                    TableAventuresJson.COLONNE_JSON + " TEXT )";


    public static final String SQL_DELETE_TABLE_AVENTURE =
            "DROP TABLE IF EXISTS " + TableAventures.NOM_TABLE;

    public static final String SQL_DELETE_TABLE_AVENTURE_JSON =
            "DROP TABLE IF EXISTS " + TableAventuresJson.NOM_TABLE;
}
