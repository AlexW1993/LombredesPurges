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

public class LesPurges extends Fragment {

    /**
     * Declaration des Attributs
     */
    Button btnContinuer;
    NavController navController;

    public LesPurges() {
        // Required empty public constructor
    }

    public static LesPurges newInstance(String param1, String param2) {
        LesPurges fragment = new LesPurges();
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
        return inflater.inflate(R.layout.les_purges, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnContinuer = view.findViewById(R.id.buttonPurges);
        navController = Navigation.findNavController(view);

        btnContinuer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.linvasion);
                    }
                }
        );

    }


}
