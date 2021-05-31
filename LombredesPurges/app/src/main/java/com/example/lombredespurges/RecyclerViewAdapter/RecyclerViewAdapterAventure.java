package com.example.lombredespurges.RecyclerViewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lombredespurges.R;
import com.example.lombredespurges.présentation.PrésentateurListeAventures;

import java.util.List;

public class RecyclerViewAdapterAventure extends RecyclerView.Adapter<RecyclerViewAdapterAventure.ViewHolder> {
    private List<String> _dataServeur;
    private List<String> _dataBD;
    private LayoutInflater _mInflater;
    private PrésentateurListeAventures _présentateur;
    private NavController navController;

    public RecyclerViewAdapterAventure(Context ctx, List<String> dataServeur, List<String> dataBD, PrésentateurListeAventures présentateur) {
        this._dataServeur = dataServeur;
        this._dataBD = dataBD;
        this._mInflater = LayoutInflater.from(ctx);
        this._présentateur = présentateur;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _mInflater.inflate(R.layout.aventure_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if(_dataServeur != null){
            return _dataServeur.size();
        } else if (_dataServeur == null){
            return _dataBD.size();
        } else{
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setVisibility(View.VISIBLE);

        if(_dataServeur != null){
            String title = _dataServeur.get(position);
            if(_dataBD != null){
                for (int i = 0; i <_dataBD.size() ; i++) {
                    if (title.equals(_dataBD.get(i))){
                        holder.image.setVisibility(View.INVISIBLE);
                    }
                }
            }
            holder.aventure.setText(title);
            holder.boutonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Boolean confirmationAventureDansBD = false;

                            if(_dataBD == null){
                                _présentateur.sauvegarderAventure(title);
                            } else {
                                for (int i = 0; i < _dataBD.size() ; i++) {
                                    if(title.equals(_dataBD.get(i))){
                                        confirmationAventureDansBD = true;
                                    }
                                }
                            }
                            if(confirmationAventureDansBD == false){
                                _présentateur.sauvegarderAventure(title);
                            }
                            _présentateur.aventureÀJouer(title);
                        }
                    }).start();
                    Bundle bundle = new Bundle();
                    bundle.putString("race", "");
                    Navigation.findNavController(v).navigate(holder.aventureTele,bundle);
                    //holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(holder.aventureTele, bundle));
                }
            });
        } else {
            String title = _dataBD.get(position);
            for (int i = 0; i <_dataBD.size() ; i++) {
                if (title.equals(_dataBD.get(i))){
                    holder.image.setVisibility(View.INVISIBLE);
                }
            }
            holder.aventure.setText(title);
            holder.boutonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            _présentateur.aventureÀJouer(title);
                        }
                    }).start();
                    Bundle bundle = new Bundle();
                    bundle.putString("race", "");
                    holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(holder.aventureTele, bundle));
                }
            });
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView aventure;
        ImageView image;
        Button boutonOk;
        int aventureTele;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            aventure = itemView.findViewById(R.id.texteTitleAventure );
            image = itemView.findViewById(R.id.imageEtoile);
            boutonOk = itemView.findViewById(R.id.buttonSelectionner);
            aventureTele = R.id.creationPersonnage;

        }
    }
}
