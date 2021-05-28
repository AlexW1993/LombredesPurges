package com.example.lombredespurges.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lombredespurges.R;
import com.example.lombredespurges.présentation.PrésentateurListeAventures;

import java.util.List;

public class MonRecyclerViewAdapter extends RecyclerView.Adapter<MonRecyclerViewAdapter.ViewHolder> {
    private List<String> _dataServeur;
    private List<String> _dataBD;
    private LayoutInflater _mInflater;
    private PrésentateurListeAventures _présentateur;

    public MonRecyclerViewAdapter(Context ctx, List<String> dataServeur, List<String> dataBD, PrésentateurListeAventures présentateur) {
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
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = _dataServeur.get(position);
        Boolean confirmationImage = false;
        holder.image.setVisibility(View.VISIBLE);
        if(_dataServeur != null){
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
                }
            });
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView aventure;
        ImageView image;
        Button boutonOk;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            aventure = itemView.findViewById(R.id.texteTitleAventure );
            image = itemView.findViewById(R.id.imageEtoile);
            boutonOk = itemView.findViewById(R.id.buttonSelectionner);
        }
    }
}
