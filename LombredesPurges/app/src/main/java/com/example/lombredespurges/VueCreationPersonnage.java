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

import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.présentation.IContratPrésentateurVueCreationPersonnage;
import com.example.lombredespurges.présentation.PrésentateurCreationPersonnage;

public class VueCreationPersonnage extends Fragment implements IContratPrésentateurVueCreationPersonnage.IVueCreationPersonnage {

    /**
     * Declaration des Attributs
     */
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
    //Personnage personnage;

    PrésentateurCreationPersonnage présentateurCreationPersonnage;

    public VueCreationPersonnage() {
        // Required empty public constructor
    }

    public static VueCreationPersonnage newInstance(String param1, String param2) {
        VueCreationPersonnage fragment = new VueCreationPersonnage();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        présentateurCreationPersonnage = new PrésentateurCreationPersonnage(this);
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
        raceImage = view.findViewById(R.id.imageRaceCreationPersonnage);
        raceNom = view.findViewById(R.id.nomRace);
        raceDescription = view.findViewById(R.id.descriptionRace);

        txtForce = view.findViewById(R.id.forceCreationPersonnage);
        txtEndurence= view.findViewById(R.id.endurenceCreationPersonnage);
        txtAgilité = view.findViewById(R.id.agilitéCreationPersonnage);
        txtIntelligence = view.findViewById(R.id.intelligenceCreationPersonnage);

        btnForce = view.findViewById(R.id.imageView12);
        btnForce.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnForce.setVisibility(View.GONE);
                        présentateurCreationPersonnage.calculerAttribut("force");
                    }
                }
        );
        btnEndurence = view.findViewById(R.id.imageView13);
        btnEndurence.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnEndurence.setVisibility(View.GONE);
                        présentateurCreationPersonnage.calculerAttribut("endurance");
                    }
                }
        );
        btnAgilité = view.findViewById(R.id.imageView14);
        btnAgilité.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnAgilité.setVisibility(View.GONE);
                        présentateurCreationPersonnage.calculerAttribut("agilité");
                    }
                }
        );
        btnIntelligence = view.findViewById(R.id.imageView15);
        btnIntelligence.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnIntelligence.setVisibility(View.GONE);
                        présentateurCreationPersonnage.calculerAttribut("intelligence");
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

                            présentateurCreationPersonnage.informationPersonnage(editName.getText().toString(),force,endurence,agilité,intelligence);
                            //présentateurCreationPersonnage.chercherpersonnage(bundle);
                            //bundle.putSerializable("Personnage",personnage);
                            présentateurCreationPersonnage.choixAventure(nomRace,bundle);
                        }
                    }
                }
        );
    }

    
    public void changerRace() {
        String nomRace = getArguments().getString("race");
        présentateurCreationPersonnage.choisirRace(nomRace);
    }



    @Override
    public void setRace(String race,int description, int codeImage) {
        raceNom.setText(race);
        raceDescription.setText(description);
        raceImage.setImageDrawable(getResources().getDrawable(codeImage));
    }

    @Override
    public void afficherAventure(int choix, Bundle bundle) {
        navController.navigate(choix, bundle);
    }

    @Override
    public void ajouterPersonnage(Personnage unPersonnage, Bundle bundle) {
        bundle.putSerializable("Personnage",unPersonnage);
    }

    @Override
    public void ajouterForcePersonnage(int pointsTotal) {
        force = pointsTotal;
        txtForce.setText(" = " + force);
    }

    @Override
    public void ajouterEndurancePersonnage(int pointsTotal) {
        endurence = pointsTotal;
        txtEndurence.setText(" = " + endurence);
    }

    @Override
    public void ajouterAgilitéPersonnage(int pointsTotal) {
        agilité = pointsTotal;
        txtAgilité.setText(" = " + agilité);
    }

    @Override
    public void ajouterIntelligencePersonnage(int pointsTotal) {
        intelligence = pointsTotal;
        txtIntelligence.setText(" = " + intelligence);
    }
}
