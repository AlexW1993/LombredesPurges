package com.example.lombredespurges.source_de_données;

import android.content.Context;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AutreAventure;
import com.example.lombredespurges.domaine.entité.aventuresTéléchargeables.AventureTéléchargeable;
import com.example.lombredespurges.domaine.interacteur.SourceDeDonnées;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class SourceDeDonnéesHTTP implements SourceDeDonnées {

    /**
     * Declaration des Attributs
     */
    private Context _ctx;
    private String _url;
    private Gson gson = new Gson();

    /**
     * Constructeur de SourceDeDonnéesHTTP.
     */
    public SourceDeDonnéesHTTP(Context ctx, String urlSource) {
        _ctx = ctx;
        _url = urlSource;
    }

    /**
     * La méthode permet récupérer une tableua des aventures qui ont été sauvegarder dans une serveur.
     *
     * @return (AutreAventure[]) le tableau des aventures.
     */
    @Override
    public AutreAventure[] récupérerListeServeur() {
        RequestQueue queue = Volley.newRequestQueue(_ctx);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, _url, future, future);
        queue.add(request);
        try {
            String response = future.get();
            AutreAventure[] aventures = gson.fromJson(response, AutreAventure[].class);
            return aventures;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * La méthode permet récupérer une chaine Json de une aventure qui a été sauvegarder dans une serveur.
     *
     * @return (String) la chaine Json de une aventure.
     */
    @Override
    public String récupérerAventureServeur() {
        RequestQueue queue = Volley.newRequestQueue(_ctx);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, _url, future, future);
        queue.add(request);
        try {
            String response = future.get();
            return response;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<AutreAventure> chercherTousAventures() {
        //Méthode utiliser dans SourceDeDonnéesBDHelper
        return null;
    }

    @Override
    public ArrayList<AventureTéléchargeable> chercherAventuresJson() {
        //Méthode utiliser dans SourceDeDonnéesBDHelper
        return null;
    }

    @Override
    public void ajouterAventure(String title, String url) {
        //Méthode utiliser dans SourceDeDonnéesBDHelper
    }

    @Override
    public void ajoterAventureJson(String title, String json) {

    }

    @Override
    public void reset() {
        //Méthode utiliser dans SourceDeDonnéesBDHelper
    }

}

