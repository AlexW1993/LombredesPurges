package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lombredespurges.présentation.IContratPrésentateurVueAventureTéléchargeable;
import com.example.lombredespurges.présentation.PrésentateurAventureTéléchargeable;

public class VueAventureTéléchargeable extends Fragment implements IContratPrésentateurVueAventureTéléchargeable.IVueAventureTéléchargeable {
    private TextView texteContenueChapitre;
    private TextView txtNumeroChapitre;
    private TextView texteChapitre;
    private Button btnChoix1;
    private Button btnChoix2;
    private Button btnChoix3;
    private Button btnPageTitre;
    private NavController navController;
    private Bundle bundle;
    private ImageView imgRace;

    private PrésentateurAventureTéléchargeable présentateurAventureTéléchargeable;

    public VueAventureTéléchargeable() {
        // Required empty public constructor
    }

    public static VueAventureTéléchargeable newInstance(String param1, String param2) {
        VueAventureTéléchargeable fragment = new VueAventureTéléchargeable();
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
        return inflater.inflate(R.layout.chapitre_aventuretelechargeable, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        présentateurAventureTéléchargeable = new PrésentateurAventureTéléchargeable(this);

        txtNumeroChapitre = view.findViewById(R.id.NumeroChapitreAV);
        texteChapitre = view.findViewById(R.id.texteChapitreAV);
        texteContenueChapitre = view.findViewById(R.id.contenueChapitreAV);

        btnPageTitre = view.findViewById(R.id.buttonMenuAV);
        btnPageTitre.setVisibility(View.GONE);

        btnChoix1 = view.findViewById(R.id.buttonChoix1AV);
        btnChoix2 = view.findViewById(R.id.buttonChoix2AV);
        btnChoix3 = view.findViewById(R.id.buttonChoix3AV);


        présentateurAventureTéléchargeable.gestionChapitre(-1);

        bundle = new Bundle();
        btnChoix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurAventureTéléchargeable.gestionChapitre(0);
            }
        });


        btnChoix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurAventureTéléchargeable.gestionChapitre(1);
            }
        });

        btnChoix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurAventureTéléchargeable.gestionChapitre(2);
            }
        });

        btnPageTitre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                présentateurAventureTéléchargeable.réinitialierJeu();
            }
        });


    }

    @Override
    public void afficherAventure(int numeroChapitre, String idContenueChapitre, String idChoix1, String idChoix2, String idChoix3) {
        txtNumeroChapitre.setText(String.valueOf(numeroChapitre));
        texteContenueChapitre.setText(idContenueChapitre);
        btnChoix1.setText(idChoix1);
        btnChoix2.setText(idChoix2);
        btnChoix3.setText(idChoix3);
    }

    @Override
    public void afficherFinJeu(String nomPersonnage, String idContenueChapitre) {
        texteChapitre.setText(nomPersonnage);
        txtNumeroChapitre.setVisibility(View.GONE);
        texteContenueChapitre.setText(idContenueChapitre);
        btnChoix1.setVisibility(View.GONE);
        btnChoix2.setVisibility(View.GONE);
        btnChoix3.setVisibility(View.GONE);
        btnPageTitre.setVisibility(View.VISIBLE);
    }

    @Override
    public void passerAuCombat() {
        navController.navigate(R.id.combat);
    }

    @Override
    public void passerPageTitre() {
        navController.navigate(R.id.vueMenuAventures);
    }
}
