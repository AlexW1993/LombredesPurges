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


    public SourceDeDonnéesBDHelper(Context context) {
        super(context, AventuresBDContrat.DATABASE_NAME, null, AventuresBDContrat.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AventuresBDContrat.SQL_CREATE_TABLE_AVENTURE);
        db.execSQL(AventuresBDContrat.SQL_CREATE_TABLE_AVENTURE_JSON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AventuresBDContrat.SQL_DELETE_TABLE_AVENTURE);
        db.execSQL(AventuresBDContrat.SQL_DELETE_TABLE_AVENTURE_JSON);
        onCreate(db);
    }

    @Override
    public void ajouterAventure(String title, String url){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AventuresBDContrat.TableAventures.COLONNE_TITLE,title);
        values.put(AventuresBDContrat.TableAventures.COLONNE_URL,url);

        db.insert(AventuresBDContrat.TableAventures.NOM_TABLE,null, values);
    }


    @Override
        public void ajoterAventureJson(String title, String json) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AventuresBDContrat.TableAventuresJson.COLONNE_TITLE,title);
        values.put(AventuresBDContrat.TableAventuresJson.COLONNE_JSON,json);

        db.insert(AventuresBDContrat.TableAventuresJson.NOM_TABLE,null, values);
    }

    @Override
    public ArrayList<AutreAventure> chercherTousAventures(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AutreAventure> listeAventures  = new ArrayList<>();

        String[] projection = {
                BaseColumns._ID,
                AventuresBDContrat.TableAventures.COLONNE_TITLE,
                AventuresBDContrat.TableAventures.COLONNE_URL
        };

        Cursor cursor = db.query(AventuresBDContrat.TableAventures.NOM_TABLE,projection,null,null,null,null,null);

        if (cursor != null){
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
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

    @Override
    public ArrayList<AventureTéléchargeable> chercherAventuresJson() {
        Gson gson = new Gson();
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AventureTéléchargeable> listeAventures  = new ArrayList<>();
        AventureTéléchargeable aventure  = new AventureTéléchargeable();

        String[] projection = {
                BaseColumns._ID,
                AventuresBDContrat.TableAventuresJson.COLONNE_TITLE,
                AventuresBDContrat.TableAventuresJson.COLONNE_JSON
        };

        Cursor cursor = db.query(AventuresBDContrat.TableAventuresJson.NOM_TABLE,projection,null,null,null,null,null);
        if (cursor != null){
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
                String json = cursor.getString(cursor.getColumnIndex(AventuresBDContrat.TableAventuresJson.COLONNE_JSON));
                aventure = gson.fromJson(json,AventureTéléchargeable.class);
                listeAventures.add(aventure);
            }
            return listeAventures;
        } else {
            return null;
        }
    }

    @Override
    public void reset(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AventuresBDContrat.TableAventures.NOM_TABLE,null,null);
        db.delete(AventuresBDContrat.TableAventuresJson.NOM_TABLE,null,null);
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
