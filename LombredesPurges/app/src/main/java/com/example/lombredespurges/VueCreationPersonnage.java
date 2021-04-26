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
    private Button btnContinuer;
    private NavController navController;
    private EditText editName;
    private ImageView raceImage;
    private TextView raceNom;
    private TextView raceDescription;

    private ImageButton btnForce;
    private ImageButton btnEndurence;
    private ImageButton btnAgilité;
    private ImageButton btnIntelligence;

    private TextView txtForce;
    private TextView txtEndurence;
    private TextView txtAgilité;
    private TextView txtIntelligence;

    private PrésentateurCreationPersonnage présentateurCreationPersonnage;

    private int force;
    private int endurence;
    private int agilité;
    private int intelligence;



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

        navController = Navigation.findNavController(view);
        présentateurCreationPersonnage = new PrésentateurCreationPersonnage(this);

        btnContinuer = view.findViewById(R.id.buttonPersonnage);

        editName = view.findViewById(R.id.editName);
        raceImage = view.findViewById(R.id.imageRaceCreationPersonnage);
        raceNom = view.findViewById(R.id.nomRace);
        raceDescription = view.findViewById(R.id.descriptionRace);

        présentateurCreationPersonnage.choisirRace(getArguments().getString("race"));

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
                            présentateurCreationPersonnage.créationPersonnage(editName.getText().toString(),force,endurence,agilité,intelligence);
                            navController.navigate(R.id.chapitre_dino);
                        }
                    }
                }
        );
    }

    /**
     * La méthode permet changer la vue avec les information de la race choisit.
     *
     * @param race, le race choisit.
     */

    @Override
    public void setRace(String race,int description, int codeImage) {
        raceNom.setText(race);
        raceDescription.setText(description);
        raceImage.setImageDrawable(getResources().getDrawable(codeImage));
    }
    /**
     * La méthode permet afficher le points de force dans le texte.
     *
     * @param pointsTotal, les points de force du personnage.
     */
    @Override
    public void ajouterForcePersonnage(int pointsTotal) {
        force = pointsTotal;
        txtForce.setText(" = " + force);
    }

    /**
     * La méthode permet afficher le points d'endurance dans le texte.
     *
     * @param pointsTotal, les points d'endurance du personnage.
     */
    @Override
    public void ajouterEndurancePersonnage(int pointsTotal) {
        endurence = pointsTotal;
        txtEndurence.setText(" = " + endurence);
    }

    /**
     * La méthode permet afficher le points d'agilité dans le texte.
     *
     * @param pointsTotal, les points d'agilité du personnage.
     */
    @Override
    public void ajouterAgilitéPersonnage(int pointsTotal) {
        agilité = pointsTotal;
        txtAgilité.setText(" = " + agilité);
    }

    /**
     * La méthode permet afficher le points d'intelligence dans le texte.
     *
     * @param pointsTotal, les points d'intelligence du personnage.
     */
    @Override
    public void ajouterIntelligencePersonnage(int pointsTotal) {
        intelligence = pointsTotal;
        txtIntelligence.setText(" = " + intelligence);
    }
}
