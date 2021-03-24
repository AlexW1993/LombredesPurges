package com.example.lombredespurges;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Chapitre extends Fragment {

    //TextView texteRecu;
    ImageView raceChap;

    public Chapitre() {
        // Required empty public constructor
    }

    public static Chapitre newInstance(String param1, String param2) {
        Chapitre fragment = new Chapitre();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void changerImage() {

        String nomRace = getArguments().getString("nomRace");

        if (nomRace.equals("via")) {
            raceChap.setImageDrawable(getResources().getDrawable(R.drawable.via));
        } else if (nomRace.equals("kaqchikam")) {
            raceChap.setImageDrawable(getResources().getDrawable(R.drawable.kaqchikam));
        } else if (nomRace.equals("dino")) {
            raceChap.setImageDrawable(getResources().getDrawable(R.drawable.dinoh));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chapitre_histoire, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        raceChap = view.findViewById(R.id.raceChap);

        changerImage();

        /*String nom = getArguments().getString("nom");
        texteRecu = view.findViewById(R.id.texteRecu);
        texteRecu.setText(nom);*/
    }
}
