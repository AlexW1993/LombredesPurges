package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lombredespurges.modèle.Ennemie;
import com.example.lombredespurges.modèle.Personnage;

import org.w3c.dom.Text;

public class Combat extends Fragment {

    Button btnContinuer;
    Button btnPageTitre;
    NavController navController;
    Personnage personnage;
    Ennemie ennemie;

    ImageButton btnDé;

    boolean tourJoueur = false;

    TextView deroulementCombat;

    TextView coefAttaquePersonnage;
    TextView forcePersonnage;
    TextView agilitéPersonnage;
    TextView endurancePersonnage;
    TextView défencePersonnage;
    TextView nomPersonnage;

    TextView coefAttaqueEnnemi;
    TextView forceEnnemie;
    TextView agilitéEnnemie;
    TextView enduranceEnnemie;
    TextView défenceEnnemie;
    TextView nomEnnemi;

    Bundle bundle;


    public Combat() {
        // Required empty public constructor
    }

    public static Combat newInstance(String param1, String param2) {
        Combat fragment = new Combat();
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
        return inflater.inflate(R.layout.combat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //personnage = new Personnage("yev", 11,23,13,8);
        personnage = (Personnage) getArguments().getSerializable("Personnage");
        ennemie = new Ennemie("Purge",5,14,7,5);

        btnContinuer = view.findViewById(R.id.btnContinuer);
        btnPageTitre = view.findViewById(R.id.btnPageTitre);
        navController = Navigation.findNavController(view);
        btnContinuer.setVisibility(View.GONE);
        btnPageTitre .setVisibility(View.GONE);

        nomPersonnage = view.findViewById(R.id.nomPersonnage);
        nomPersonnage.setText(personnage.get_nom().toUpperCase());
        forcePersonnage = view.findViewById(R.id.forceheros);
        forcePersonnage.setText(String.valueOf(personnage.get_force()));
        agilitéPersonnage = view.findViewById(R.id.agiliteheros);
        agilitéPersonnage.setText(String.valueOf(personnage.get_agilité()));
        endurancePersonnage = view.findViewById(R.id.enduranceheros);
        endurancePersonnage.setText(String.valueOf(personnage.get_endurance()));
        défencePersonnage = view.findViewById(R.id.defenceheros);
        coefAttaquePersonnage = view.findViewById(R.id.coefAttaquePersonnage);

        nomEnnemi = view.findViewById(R.id.nomEnnemi);
        nomEnnemi.setText(ennemie.get_nom().toUpperCase());
        forceEnnemie = view.findViewById(R.id.forcepurge);
        forceEnnemie.setText(String.valueOf(ennemie.get_force()));
        agilitéEnnemie = view.findViewById(R.id.agilitepurge);
        agilitéEnnemie.setText(String.valueOf(ennemie.get_agilité()));
        enduranceEnnemie = view.findViewById(R.id.endurancepurge);
        enduranceEnnemie.setText(String.valueOf(ennemie.get_endurance()));
        défenceEnnemie = view.findViewById(R.id.defencepurge);
        coefAttaqueEnnemi = view.findViewById(R.id.coefAttaqueEnnemi);

        deroulementCombat = view.findViewById(R.id.deroulementcombattexte);
        deroulementCombat.setText("Jouer le Dé pour déterminer l'attaquant");

        btnDé = view.findViewById(R.id.combatDé);
        btnDé.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        personnage.calculerCoefAttaquePersonnage();
                        coefAttaquePersonnage.setText(String.valueOf(personnage.getCoefAttaque()));

                        ennemie.calculerCoefAttaqueEnnemi();
                        coefAttaqueEnnemi.setText(String.valueOf(ennemie.getCoefAttaque()));

                        if(personnage.getCoefAttaque() >= ennemie.getCoefAttaque()){
                            tourJoueur = true;
                        }else{
                            tourJoueur = false;
                        }

                        if (tourJoueur){
                            ennemie.calculerCoefDéfense(personnage.getCoefAttaque());
                            défenceEnnemie.setText(String.valueOf(ennemie.getCoefDéfence()));
                            ennemie.calculerEtRecevoirDommage(personnage.get_force());
                            enduranceEnnemie.setText(String.valueOf(ennemie.get_endurance()));
                            if(ennemie.get_endurance() <= 0){

                                btnContinuer.setVisibility(View.VISIBLE);
                                btnDé.setVisibility(View.GONE);
                                deroulementCombat.setText("Vous avez attaqué : " + ennemie.getDommages() + " de dommage a été fait. L'ennemi est battu");
                            }else{
                                deroulementCombat.setText("Vous avez attaqué : " + ennemie.getDommages() + " de dommage a été fait. Jouer le dé pour prochain tour");
                            }

                        }else{
                            personnage.calculerCoefDéfense(personnage.getCoefAttaque());
                            défencePersonnage.setText(String.valueOf(personnage.getCoefDéfence()));
                            personnage.calculerEtRecevoirDommage(personnage.get_force());
                            endurancePersonnage.setText(String.valueOf(personnage.get_endurance()));
                            if(personnage.get_endurance() <= 0) {
                                btnPageTitre.setVisibility(View.VISIBLE);
                                deroulementCombat.setText("Vous êtes attaqué : " + personnage.getDommages() + " de dommage a été fait. Vous êtes battu");
                                btnDé.setVisibility(View.GONE);
                            }else{
                                deroulementCombat.setText("Vous êtes attaqué : " + ennemie.getDommages() + " de dommage a été fait. Jouer le dé pour prochain tour");
                            }
                        }

                        if(personnage.get_endurance() <= 0){
                        }else if(ennemie.get_endurance() <= 0){
                            btnContinuer.setVisibility(View.VISIBLE);
                        }else {
                            deroulementCombat.setText("Jouer le Dé pour déterminer l'attaquant");
                        }
                    }
                }
        );

        btnPageTitre.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.pageTitre);
                    }
                }
        );

        btnContinuer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bundle = new Bundle();
                        bundle.putSerializable("Personnage",personnage);
                        navController.navigate(R.id.chapitre_dino, bundle);
                    }
                }
        );
    }
}
