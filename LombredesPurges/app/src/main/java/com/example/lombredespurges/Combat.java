package com.example.lombredespurges;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class Combat extends Fragment {

    Button btnContinuer;
    Button btnPageTitre;
    NavController navController;

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

        btnContinuer = view.findViewById(R.id.btnContinuer);
        btnPageTitre = view.findViewById(R.id.btnPageTitre);
        navController = Navigation.findNavController(view);
        btnContinuer.setVisibility(View.GONE);
        btnPageTitre .setVisibility(View.GONE);

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
                        navController.navigate(R.id.chapitre);
                    }
                }
        );

    }
}
