package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class CreationPersonnage extends Fragment {

    Button btnContinuer;
    NavController navController;
    EditText editName;
    ImageView raceImage;
    TextView raceNom;
    TextView raceDescription;
    String nomRaceChaphitre;



    public CreationPersonnage() {
        // Required empty public constructor
    }

    public static CreationPersonnage newInstance(String param1, String param2) {
        CreationPersonnage fragment = new CreationPersonnage();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void changerRace() {

        String nomRace = getArguments().getString("race");

        if (nomRace.equals("via")) {
            raceImage.setImageDrawable(getResources().getDrawable(R.drawable.via));
            raceNom.setText("Race: V.I.A.");
            raceDescription.setText(R.string.descriptionVia);
            nomRaceChaphitre = "via";
        } else if (nomRace.equals("kaqchikam")) {
            raceImage.setImageDrawable(getResources().getDrawable(R.drawable.kaqchikam));
            raceNom.setText("Race: Kaqchikam");
            raceDescription.setText(R.string.descriptionKaqchikam);
            nomRaceChaphitre = "kaqchikam";
        } else if (nomRace.equals("dino")) {
            raceImage.setImageDrawable(getResources().getDrawable(R.drawable.dinoh));
            raceNom.setText("Race: Dino");
            raceDescription.setText(R.string.descriptionDino);
            nomRaceChaphitre = "dino";
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
        return inflater.inflate(R.layout.creation_personnage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnContinuer = view.findViewById(R.id.buttonPersonnage);
        navController = Navigation.findNavController(view);
        editName = view.findViewById(R.id.editName);
        raceImage = view.findViewById(R.id.race);
        raceNom = view.findViewById(R.id.race_texte);
        raceDescription = view.findViewById(R.id.descriptionRace);

        changerRace();

        btnContinuer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("nomRace", nomRaceChaphitre);
                        bundle.putString("nom", editName.getText().toString());
                        navController.navigate(R.id.chapitre_dino, bundle);
                        String nomRace = getArguments().getString("race");
                        if (nomRace.equals("dino")){
                            navController.navigate(R.id.chapitre_dino, bundle);
                        } else if (nomRace.equals("via")){
                            navController.navigate(R.id.chapitre_via, bundle);
                        }else if (nomRace.equals("kaqchikam")) {
                            navController.navigate(R.id.chapitre_dino, bundle);
                        }
                    }
                }
        );

    }

}
