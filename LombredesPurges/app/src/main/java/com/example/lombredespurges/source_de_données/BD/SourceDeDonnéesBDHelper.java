package com.example.lombredespurges.source_de_données.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.lombredespurges.domaine.entité.AutreAventure;
import com.example.lombredespurges.domaine.interacteur.SourceDeDonnées;

import java.util.ArrayList;


public class SourceDeDonnéesBDHelper extends SQLiteOpenHelper implements SourceDeDonnées {


    public SourceDeDonnéesBDHelper(Context context) {
        super(context, AventuresBDContrat.DATABASE_NAME, null, AventuresBDContrat.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AventuresBDContrat.SQL_CREATE_TABLE_AVENTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AventuresBDContrat.SQL_DELETE_TABLE_AVENTURE);
        onCreate(db);
    }

    @Override
    public void ajouterAventure(String title, String url){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AventuresBDContrat.TableAventure.COLONNE_TITLE,title);
        values.put(AventuresBDContrat.TableAventure.COLONNE_URL,url);

        db.insert(AventuresBDContrat.TableAventure.NOM_TABLE,null, values);
    }


    @Override
    public ArrayList<AutreAventure> chercherTousAventures(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AutreAventure> listeAventures  = new ArrayList<>();
        AutreAventure aventure = new AutreAventure();

        String[] projection = {
                BaseColumns._ID,
                AventuresBDContrat.TableAventure.COLONNE_TITLE,
                AventuresBDContrat.TableAventure.COLONNE_URL
        };

        Cursor cursor = db.query(AventuresBDContrat.TableAventure.NOM_TABLE,projection,null,null,null,null,null);

        if (cursor != null){
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
                aventure.setTitle(cursor.getString(cursor.getColumnIndex(AventuresBDContrat.TableAventure.COLONNE_TITLE)));
                aventure.setUrl(cursor.getString(cursor.getColumnIndex(AventuresBDContrat.TableAventure.COLONNE_URL)));
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
        db.delete(AventuresBDContrat.TableAventure.NOM_TABLE,null,null);
    }

    @Override
    public AutreAventure[] récupérerListeServeur() {
        return new AutreAventure[0];
    }

}
