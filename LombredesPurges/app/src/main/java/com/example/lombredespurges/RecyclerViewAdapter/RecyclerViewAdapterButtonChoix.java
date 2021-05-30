package com.example.lombredespurges.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lombredespurges.R;
import com.example.lombredespurges.présentation.PrésentateurAventureTéléchargeable;

public class RecyclerViewAdapterButtonChoix extends RecyclerView.Adapter<RecyclerViewAdapterButtonChoix.ViewHolderChapitre> {
    private LayoutInflater _inflater;
    private PrésentateurAventureTéléchargeable _présentateur;
    private int[] choix;
    private String[] descriptionChoix;

    public RecyclerViewAdapterButtonChoix(Context context, PrésentateurAventureTéléchargeable _présentateur, int[] choix, String[] descriptionChoix) {
        this._inflater = LayoutInflater.from(context);
        this._présentateur = _présentateur;
        this.choix = choix;
        this.descriptionChoix = descriptionChoix;
    }

    @NonNull
    @Override
    public ViewHolderChapitre onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.button_choix,parent,false);
        return new ViewHolderChapitre(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChapitre holder, int position) {
        holder.btnChoix.setText(descriptionChoix[position]);
        holder.btnChoix.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                _présentateur.gestionChapitre(choix[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(descriptionChoix != null){
            return descriptionChoix.length;
        }else{
            return 0;
        }
    }

    public class ViewHolderChapitre extends RecyclerView.ViewHolder{
        Button btnChoix;
        public ViewHolderChapitre(@NonNull View itemView) {
            super(itemView);
            btnChoix = itemView.findViewById(R.id.buttonChoix);
        }
    }
}
