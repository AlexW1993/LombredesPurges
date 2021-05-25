package com.example.lombredespurges.source_de_données;

import android.content.Context;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lombredespurges.domaine.entité.AutreAventure;
import com.example.lombredespurges.domaine.entité.Chapitre;
import com.example.lombredespurges.domaine.interacteur.SourceDeDonnées;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class SourceDeDonnéesHTTP implements SourceDeDonnées {

    private Context _ctx;
    private String _url;
    private Gson gson = new Gson();

    public SourceDeDonnéesHTTP(Context ctx, String urlSource) {
        _ctx = ctx;
        _url = urlSource;
    }


    @Override
    public AutreAventure[] récupérerListeServeur() {
        RequestQueue queue = Volley.newRequestQueue(_ctx);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET,_url,future,future);
        queue.add(request);
        AutreAventure[] aventures = null;
        try {
            String response = future.get();
            aventures = gson.fromJson(response, AutreAventure[].class);
            return aventures;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return aventures;
    }


    @Override
    public ArrayList<AutreAventure> chercherTousAventures() {
        //Méthode utiliser dans SourceDeDonnéesBDHelper
        return null;
    }

    @Override
    public void ajouterAventure(String title, String url) {
        //Méthode utiliser dans SourceDeDonnéesBDHelper
    }

    @Override
    public void reset() {
        //Méthode utiliser dans SourceDeDonnéesBDHelper
    }

}

