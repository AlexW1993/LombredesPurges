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

import com.example.lombredespurges.modèle.Personnage;
import com.example.lombredespurges.presentateur.PresentateurCombat;


public class Combat extends Fragment {

    /**
     * Declaration des Attributs
     */
    Button btnContinuer;
    Button btnPageTitre;
    NavController navController;
    Personnage personnage;

    ImageButton btnDé;

    boolean tourJoueur = false;

    int accionDuTour;
    int resultatEndurance;

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

    PresentateurCombat presentateurCombat;


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

        presentateurCombat = new PresentateurCombat(this);
        personnage = (Personnage) getArguments().getSerializable("Personnage");
        presentateurCombat.personnage(personnage);

        btnContinuer = view.findViewById(R.id.btnContinuer);
        btnPageTitre = view.findViewById(R.id.btnPageTitre);
        navController = Navigation.findNavController(view);
        btnContinuer.setVisibility(View.GONE);
        btnPageTitre .setVisibility(View.GONE);

        nomPersonnage = view.findViewById(R.id.nomPersonnage);
        nomPersonnage.setText(presentateurCombat.nomPersonnage().toUpperCase());
        forcePersonnage = view.findViewById(R.id.forceheros);
        forcePersonnage.setText(String.valueOf(presentateurCombat.forcePersonnage()));
        agilitéPersonnage = view.findViewById(R.id.agiliteheros);
        agilitéPersonnage.setText(String.valueOf(presentateurCombat.agilitéPersonnage()));
        endurancePersonnage = view.findViewById(R.id.enduranceheros);
        endurancePersonnage.setText(String.valueOf(presentateurCombat.endurencePersonnage()));
        défencePersonnage = view.findViewById(R.id.defenceheros);
        coefAttaquePersonnage = view.findViewById(R.id.coefAttaquePersonnage);

        nomEnnemi = view.findViewById(R.id.nomEnnemi);
        nomEnnemi.setText(presentateurCombat.nomEnnemie().toUpperCase());
        forceEnnemie = view.findViewById(R.id.forcepurge);
        forceEnnemie.setText(String.valueOf(presentateurCombat.forceEnnemie()));
        agilitéEnnemie = view.findViewById(R.id.agilitepurge);
        agilitéEnnemie.setText(String.valueOf(presentateurCombat.agilitéPersonnage()));
        enduranceEnnemie = view.findViewById(R.id.endurancepurge);
        enduranceEnnemie.setText(String.valueOf(presentateurCombat.endurenceEnnemie()));
        défenceEnnemie = view.findViewById(R.id.defencepurge);
        coefAttaqueEnnemi = view.findViewById(R.id.coefAttaqueEnnemi);

        deroulementCombat = view.findViewById(R.id.deroulementcombattexte);
        deroulementCombat.setText("Jouer le Dé pour déterminer l'attaquant");

        btnDé = view.findViewById(R.id.combatDé);
        btnDé.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presentateurCombat.calculerCoefAttaque();
                        coefAttaquePersonnage.setText(String.valueOf(presentateurCombat.coefAttaquePersonnage()));
                        coefAttaqueEnnemi.setText(String.valueOf(presentateurCombat.coefAttaqueEnnemie()));
                        tourJoueur = presentateurCombat.comparaisonCoefAttaque();
                        accionDuTour = presentateurCombat.tourDAttaquer(tourJoueur);
                        if (tourJoueur){
                            défenceEnnemie.setText(String.valueOf(presentateurCombat.coefDefencéEnnemie()));
                            enduranceEnnemie.setText(String.valueOf(presentateurCombat.endurenceEnnemie()));
                            if(accionDuTour == 1){
                                btnContinuer.setVisibility(View.VISIBLE);
                                btnDé.setVisibility(View.GONE);
                                deroulementCombat.setText("Vous avez attaqué : " + presentateurCombat.dommagesEnnemie() + " de dommage a été fait. L'ennemi est battu");
                            }else if (accionDuTour == 2){
                                deroulementCombat.setText("Vous avez attaqué : " + presentateurCombat.dommagesEnnemie() + " de dommage a été fait. Jouer le dé pour prochain tour");
                            }
                        }else{
                            défencePersonnage.setText(String.valueOf(presentateurCombat.coefDefencéPersonnage()));
                            endurancePersonnage.setText(String.valueOf(presentateurCombat.endurencePersonnage()));
                            if(accionDuTour == 3) {
                                btnPageTitre.setVisibility(View.VISIBLE);
                                deroulementCombat.setText("Vous êtes attaqué : " + presentateurCombat.dommagesPersonnage() + " de dommage a été fait. Vous êtes battu");
                                btnDé.setVisibility(View.GONE);
                            }else if (accionDuTour == 4){
                                deroulementCombat.setText("Vous êtes attaqué : " + presentateurCombat.dommagesPersonnage() + " de dommage a été fait. Jouer le dé pour prochain tour");
                            }
                        }

                        resultatEndurance = presentateurCombat.comparerEndurance();
                        if(resultatEndurance == 1){
                            btnPageTitre.setVisibility(View.VISIBLE);
                        }else if(resultatEndurance == 2){
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
                        bundle.putBoolean("CombatFinit",true);
                        bundle.putInt("ChoixPasséeAction", getArguments().getInt("ChoixPassée"));
                        bundle.putInt("Étape",getArguments().getInt("ÉtapeVue"));

                        bundle.putString("ChapitreCouranteAction",getArguments().getString("ChapitreCourante"));
                        navController.navigate(R.id.chapitre_dino, bundle);
                    }
                }
        );
    }
}