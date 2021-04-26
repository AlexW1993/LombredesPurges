package com.example.lombredespurges;

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

public class VueSelectionAventure extends Fragment {

    /**
     * Declaration des Attributs
     */
    private Button btnDino;
    private Button btnVia;
    private Button btnKaqchikam;
    private NavController navController;

    public VueSelectionAventure() {
        // Required empty public constructor
    }

    public static VueSelectionAventure newInstance(String param1, String param2) {
        VueSelectionAventure fragment = new VueSelectionAventure();
        Bundle args = new Bundle();
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
        return inflater.inflate(R.layout.selection_aventure, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDino = view.findViewById(R.id.buttonDino);
        btnVia = view.findViewById(R.id.buttonVIA);
        btnKaqchikam = view.findViewById(R.id.buttonKaqchikam);
        navController = Navigation.findNavController(view);


        btnDino.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("race", "Dino");
                        navController.navigate(R.id.creationPersonnage, bundle);
                    }
                }
        );

        btnVia.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("race", "Via");
                        navController.navigate(R.id.creationPersonnage, bundle);
                    }
                }
        );

        btnKaqchikam.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("race", "Kachikam");
                        navController.navigate(R.id.creationPersonnage, bundle);
                    }
                }
        );

    }
}
