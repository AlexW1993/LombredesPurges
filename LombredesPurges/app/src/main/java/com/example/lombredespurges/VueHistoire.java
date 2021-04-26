package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.présentation.IContratPrésentateurVueHistoires;
import com.example.lombredespurges.présentation.PrésentateurHistoires;

public class VueHistoire extends Fragment implements IContratPrésentateurVueHistoires.IVueHistoire {

    private TextView texteContenueChapitre;
    private TextView txtNumeroChapitre;
    private TextView texteChapitre;
    private Button btnChoix1;
    private Button btnChoix2;
    private Button btnChoix3;
    private Button btnPageTitre;
    private NavController navController;
    private Bundle bundle;

    private PrésentateurHistoires présentateurHistoires;

    public VueHistoire() {
        // Required empty public constructor
    }

    public static VueHistoire newInstance(String param1, String param2) {
        VueHistoire fragment = new VueHistoire();
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
        return inflater.inflate(R.layout.chapitre_histoire_dino, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        présentateurHistoires = new PrésentateurHistoires(this);

        txtNumeroChapitre = view.findViewById(R.id.NumeroChapitre);
        texteChapitre = view.findViewById(R.id.texteChapitre);
        texteContenueChapitre = view.findViewById(R.id.contenueChapitre);

        btnPageTitre = view.findViewById(R.id.buttonMenu);
        btnPageTitre.setVisibility(View.GONE);

        btnChoix1 = view.findViewById(R.id.buttonChoix1);
        btnChoix2 = view.findViewById(R.id.buttonChoix2);
        btnChoix3 = view.findViewById(R.id.buttonChoix3);


        présentateurHistoires.gestionChapitre(-1);

        bundle = new Bundle();
        btnChoix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurHistoires.gestionChapitre(0);
            }
        });


        btnChoix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurHistoires.gestionChapitre(1);
            }
        });

        btnChoix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurHistoires.gestionChapitre(2);
            }
        });

        btnPageTitre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.pageTitre);
            }
        });


    }

    @Override
    public void afficherAventure(int numeroChapitre, int idContenueChapitre,int idChoix1,int idChoix2,int idChoix3) {
        txtNumeroChapitre.setText(String.valueOf(numeroChapitre));
        texteContenueChapitre.setText(idContenueChapitre);
        btnChoix1.setText(idChoix1);
        btnChoix2.setText(idChoix2);
        btnChoix3.setText(idChoix3);
    }

    public void afficherFinJeu(int numeroChapitre, int idContenueChapitre){
        txtNumeroChapitre.setText(String.valueOf(numeroChapitre));
        texteContenueChapitre.setText(idContenueChapitre);
        btnChoix1.setVisibility(View.GONE);
        btnChoix2.setVisibility(View.GONE);
        btnChoix3.setVisibility(View.GONE);
        btnPageTitre.setVisibility(View.VISIBLE);
    }

    @Override
    public void passerAuCombat(){
        navController.navigate(R.id.combat);
    }
}