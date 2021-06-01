package com.example.lombredespurges.source_de_données.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AventureTéléchargeable;
import com.example.lombredespurges.domaine.interacteur.SourceDeDonnées;
import com.google.gson.Gson;

import java.util.ArrayList;


public class SourceDeDonnéesBDHelper extends SQLiteOpenHelper implements SourceDeDonnées {

    /**
     * Constructeur de SourceDeDonnéesHTTP.
     */
    public SourceDeDonnéesBDHelper(Context context) {
        super(context, AventuresBDContrat.DATABASE_NAME, null, AventuresBDContrat.DATABASE_VERSION);
    }

    /**
     * La méthode permet la creation de la BD.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AventuresBDContrat.SQL_CREATE_TABLE_AVENTURE);
        db.execSQL(AventuresBDContrat.SQL_CREATE_TABLE_AVENTURE_JSON);
    }

    /**
     * La méthode permet mettre à jour la BD.
     *
     * @param (db,oldVersion,newVersion), le BD, la vieux version de la BD et la nouvelle version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AventuresBDContrat.SQL_DELETE_TABLE_AVENTURE);
        db.execSQL(AventuresBDContrat.SQL_DELETE_TABLE_AVENTURE_JSON);
        onCreate(db);
    }

    /**
     * La méthode permet sauvegarder une reference d'aventure dans la BD
     *
     * @param (title,url), le nom et l'url de l'aventure.
     */
    @Override
    public void ajouterAventure(String title, String url) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AventuresBDContrat.TableAventures.COLONNE_TITLE, title);
        values.put(AventuresBDContrat.TableAventures.COLONNE_URL, url);

        db.insert(AventuresBDContrat.TableAventures.NOM_TABLE, null, values);
    }

    /**
     * La méthode permet sauvegarder une aventure dans la BD
     *
     * @param (title,json), le nom et la chaine Json de une aventure.
     */
    @Override
    public void ajoterAventureJson(String title, String json) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AventuresBDContrat.TableAventuresJson.COLONNE_TITLE, title);
        values.put(AventuresBDContrat.TableAventuresJson.COLONNE_JSON, json);

        db.insert(AventuresBDContrat.TableAventuresJson.NOM_TABLE, null, values);
    }

    /**
     * La méthode permet cherhcer les reference des aventures dans la BD.
     *
     * @return (ArrayList < AutreAventure >) La liste de reference des aventures.
     */
    @Override
    public ArrayList<AutreAventure> chercherTousAventures() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AutreAventure> listeAventures = new ArrayList<>();

        String[] projection = {
                BaseColumns._ID,
                AventuresBDContrat.TableAventures.COLONNE_TITLE,
                AventuresBDContrat.TableAventures.COLONNE_URL
        };

        Cursor cursor = db.query(AventuresBDContrat.TableAventures.NOM_TABLE, projection, null, null, null, null, null);

        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                AutreAventure aventure = new AutreAventure();
                aventure.setTitle(cursor.getString(cursor.getColumnIndex(AventuresBDContrat.TableAventures.COLONNE_TITLE)));
                aventure.setUrl(cursor.getString(cursor.getColumnIndex(AventuresBDContrat.TableAventures.COLONNE_URL)));
                listeAventures.add(aventure);
            }
            return listeAventures;
        } else {
            return null;
        }
    }

    /**
     * La méthode permet cherhcer les  aventures dans la BD.
     *
     * @return (ArrayList < AventureTéléchargeable >) La liste des aventures.
     */
    @Override
    public ArrayList<AventureTéléchargeable> chercherAventuresJson() {
        Gson gson = new Gson();
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AventureTéléchargeable> listeAventures = new ArrayList<>();
        AventureTéléchargeable aventure = new AventureTéléchargeable();

        String[] projection = {
                BaseColumns._ID,
                AventuresBDContrat.TableAventuresJson.COLONNE_TITLE,
                AventuresBDContrat.TableAventuresJson.COLONNE_JSON
        };

        Cursor cursor = db.query(AventuresBDContrat.TableAventuresJson.NOM_TABLE, projection, null, null, null, null, null);
        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                String json = cursor.getString(cursor.getColumnIndex(AventuresBDContrat.TableAventuresJson.COLONNE_JSON));
                aventure = gson.fromJson(json, AventureTéléchargeable.class);
                listeAventures.add(aventure);
            }
            return listeAventures;
        } else {
            return null;
        }
    }

    /**
     * La méthode permet reinicier les tableaux de la BD
     */
    @Override
    public void reset() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AventuresBDContrat.TableAventures.NOM_TABLE, null, null);
        db.delete(AventuresBDContrat.TableAventuresJson.NOM_TABLE, null, null);
    }

    @Override
    public AutreAventure[] récupérerListeServeur() {
        //Méthode utiliser dans SourceDeDonnéesHTTP
        return new AutreAventure[0];
    }

    @Override
    public String récupérerAventureServeur() {
        //Méthode utiliser dans SourceDeDonnéesHTTP
        return null;
    }

}
