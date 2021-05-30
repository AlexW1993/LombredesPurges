package com.example.lombredespurges;

import android.content.Context;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lombredespurges.RecyclerViewAdapter.RecyclerViewAdapterAventure;
import com.example.lombredespurges.RecyclerViewAdapter.RecyclerViewAdapterButtonChoix;
import com.example.lombredespurges.présentation.IContratPrésentateurVueAventureTéléchargeable;
import com.example.lombredespurges.présentation.PrésentateurAventureTéléchargeable;

public class VueAventureTéléchargeable extends Fragment implements IContratPrésentateurVueAventureTéléchargeable.IVueAventureTéléchargeable {
    private TextView texteContenueChapitre;
    private TextView txtNumeroChapitre;
    private TextView texteChapitre;
    private Button btnPageTitre;
    private NavController navController;

    private RecyclerViewAdapterButtonChoix _adapter;
    private RecyclerView listeButtons;


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

        listeButtons = view.findViewById(R.id.listeButtonsChoix);

        btnPageTitre = view.findViewById(R.id.buttonMenuAV);
        btnPageTitre.setVisibility(View.GONE);



        présentateurAventureTéléchargeable.gestionChapitre(-1);

        bundle = new Bundle();


    }

    @Override
    public void afficherAventure(int numeroChapitre, String idContenueChapitre, int[] listeChoix, String[] choixDescription, Context context) {
        txtNumeroChapitre.setText(String.valueOf(numeroChapitre));
        texteContenueChapitre.setText(idContenueChapitre);
        listeButtons.setLayoutManager(new LinearLayoutManager(context));
        _adapter = new RecyclerViewAdapterButtonChoix(context,présentateurAventureTéléchargeable, listeChoix, choixDescription);
        listeButtons.setAdapter(_adapter);
    }

    @Override
    public void afficherFinJeu(String nomPersonnage, String idContenueChapitre) {
        texteChapitre.setText(nomPersonnage);
        txtNumeroChapitre.setVisibility(View.GONE);
        texteContenueChapitre.setText(idContenueChapitre);

        //tous les buttons gone
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
