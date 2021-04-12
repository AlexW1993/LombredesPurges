package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lombredespurges.modèle.Personnage;

import java.util.Random;

public class CreationPersonnage extends Fragment {

    Button btnContinuer;
    NavController navController;
    EditText editName;
    ImageView raceImage;
    TextView raceNom;
    TextView raceDescription;

    ImageButton btnForce;
    ImageButton btnEndurence;
    ImageButton btnAgilité;
    ImageButton btnIntelligence;

    TextView txtForce;
    TextView txtEndurence;
    TextView txtAgilité;
    TextView txtIntelligence;

    int force;
    int endurence;
    int agilité;
    int intelligence;
    Personnage personnage;






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
            //raceImage.setImageDrawable(getResources().getDrawable(R.drawable.via));
            raceNom.setText("Race: V.I.A.");
            raceDescription.setText(R.string.descriptionVia);
        } else if (nomRace.equals("kaqchikam")) {
            //raceImage.setImageDrawable(getResources().getDrawable(R.drawable.kaqchikam));
            raceNom.setText("Race: Kaqchikam");
            raceDescription.setText(R.string.descriptionKaqchikam);
        } else if (nomRace.equals("dino")) {
            //raceImage.setImageDrawable(getResources().getDrawable(R.drawable.dinoh));
            raceNom.setText("Race: Dino");
            raceDescription.setText(R.string.descriptionDino);
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

        txtForce = view.findViewById(R.id.textView22);
        txtEndurence= view.findViewById(R.id.textView24);
        txtAgilité = view.findViewById(R.id.textView25);
        txtIntelligence = view.findViewById(R.id.textView26);

        btnForce = view.findViewById(R.id.imageView12);
        btnForce.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnForce.setVisibility(View.GONE);
                        int num = new Random().nextInt((6 - 1) + 1) + 1;
                        force = 10 + num;
                        txtForce.setText(" = " + force);
                    }
                }
        );
        btnEndurence = view.findViewById(R.id.imageView13);
        btnEndurence.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnEndurence.setVisibility(View.GONE);
                        int num = new Random().nextInt((10 - 1) + 1) + 1;
                        endurence = 20 + (3 * num);
                        txtEndurence.setText(" = " + endurence);
                    }
                }
        );
        btnAgilité = view.findViewById(R.id.imageView14);
        btnAgilité.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnAgilité.setVisibility(View.GONE);
                        int num = new Random().nextInt((6 - 1) + 1) + 1;
                        agilité = 10 + num;
                        txtAgilité.setText(" = " + agilité);
                    }
                }
        );
        btnIntelligence = view.findViewById(R.id.imageView15);
        btnIntelligence.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnIntelligence.setVisibility(View.GONE);
                        int num = new Random().nextInt((6 - 1) + 1) + 1;
                        intelligence = 5 + num;
                        txtIntelligence.setText(" = " + intelligence);
                    }
                }
        );

        changerRace();

        btnContinuer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editName.getText().toString().trim().equals("") ||
                        btnForce.getVisibility() == View.VISIBLE || btnEndurence.getVisibility() == View.VISIBLE||
                        btnAgilité.getVisibility() == View.VISIBLE || btnIntelligence.getVisibility() == View.VISIBLE){
                            return;
                        }else{
                            Bundle bundle = new Bundle();
                            bundle.putString("nom", editName.getText().toString());
                            String nomRace = getArguments().getString("race");
                            bundle.putString("nomRace", nomRace);

                            personnage = new Personnage(editName.getText().toString(),force,endurence,agilité,intelligence);
                            bundle.putSerializable("Personnage",personnage);

                            if (nomRace.equals("dino")){
                                navController.navigate(R.id.chapitre_dino, bundle);
                            } else if (nomRace.equals("via")){
                                navController.navigate(R.id.chapitre_via, bundle);
                            } else if (nomRace.equals("kaqchikam")) {
                                navController.navigate(R.id.chapitre_kachikam, bundle);
                            }

                        }

                    }
                }
        );

    }

}
