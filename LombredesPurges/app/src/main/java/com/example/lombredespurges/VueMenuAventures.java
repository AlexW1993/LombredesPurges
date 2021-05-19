package com.example.lombredespurges;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class VueMenuAventures extends Fragment {

    /**
     * Declaration des Attributs
     */
    private Button btnAventurePurges;
    private Button btnAutresAventures;
    private NavController navController;


    public VueMenuAventures() {
        // Required empty public constructor
    }

    public static VueMenuAventures newInstance(String param1, String param2) {
        VueMenuAventures fragment = new VueMenuAventures();
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
        return inflater.inflate(R.layout.menu_aventures, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnAventurePurges = view.findViewById(R.id.buttonAventuresPurges);
        btnAutresAventures = view.findViewById(R.id.buttonAutresAventures);
        navController = Navigation.findNavController(view);


        btnAventurePurges.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.pageTitre);
                    }
                }
        );

        btnAutresAventures.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.autresAventures);
                    }
                }
        );
    }
}