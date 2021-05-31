package com.example.lombredespurges;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.lombredespurges.RecyclerViewAdapter.RecyclerViewAdapterAventure;
import com.example.lombredespurges.présentation.IContratPrésentateurVueListeAventures;
import com.example.lombredespurges.présentation.PrésentateurListeAventures;

import java.util.ArrayList;

public class VueAutresAventures extends Fragment implements IContratPrésentateurVueListeAventures.IVueListeAventures {

    /**
     * Declaration des Attributs
     */
    private Button _btnRetourner;
    private NavController _navController;
    private PrésentateurListeAventures _présentateurListeAventures;
    private RecyclerView _listeAventures;
    private RecyclerViewAdapterAventure _adapter;
    private TextView _message;
    private ProgressBar spinner;

    public VueAutresAventures() {
        // Required empty public constructor
    }


    public static VueAutresAventures newInstance(String param1, String param2) {
        VueAutresAventures fragment = new VueAutresAventures();
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
        return inflater.inflate(R.layout.autres_aventures, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _btnRetourner = view.findViewById(R.id.buttonRetourner);
        _navController = Navigation.findNavController(view);
        _listeAventures = view.findViewById(R.id.listeAventures);
        _message = view.findViewById(R.id.messageSansConnexion);
        _message.setVisibility(View.INVISIBLE);
        spinner = (ProgressBar)view.findViewById(R.id.progressBar1);
        spinner.setVisibility(View.INVISIBLE);
        _présentateurListeAventures = new PrésentateurListeAventures(this);
        _présentateurListeAventures.récupererListe();


        _btnRetourner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinner.setVisibility(View.VISIBLE);
                        _navController.navigate(R.id.vueMenuAventures);
                    }
                }
        );
    }

    /**
     * La méthode permet d'afficher la liste des aventures
     */
    @Override
    public void afficherListe(ArrayList<String> listeServeur, ArrayList<String> listeBD) {

        if (listeServeur == null && listeBD != null) {
            _message.setVisibility(View.VISIBLE);
            _message.setText("Les nouvelles aventures ne peuvent être chargées.");
            _listeAventures.setLayoutManager(new LinearLayoutManager(_présentateurListeAventures.récupererContexte()));
            _adapter = new RecyclerViewAdapterAventure(_présentateurListeAventures.récupererContexte(), null, listeBD, _présentateurListeAventures);
            _listeAventures.setAdapter(_adapter);
        } else if (listeServeur == null && listeBD == null) {
            _message.setVisibility(View.VISIBLE);
            _message.setText("Les nouvelles aventures ne peuvent être chargées.");
        } else {
            _listeAventures.setLayoutManager(new LinearLayoutManager(_présentateurListeAventures.récupererContexte()));
            _adapter = new RecyclerViewAdapterAventure(_présentateurListeAventures.récupererContexte(), listeServeur, listeBD, _présentateurListeAventures);
            _listeAventures.setAdapter(_adapter);
        }


    }

}