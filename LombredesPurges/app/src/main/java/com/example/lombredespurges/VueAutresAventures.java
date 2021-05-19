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
import android.widget.TextView;


import com.example.lombredespurges.présentation.IContratPrésentateurVueListeAventures;
import com.example.lombredespurges.présentation.PrésentateurListeAventures;

public class VueAutresAventures extends Fragment implements IContratPrésentateurVueListeAventures.IVueListeAventures {

    /**
     * Declaration des Attributs
     */
    private Button _btnRetourner;
    private Button _btnCommencer;
    private NavController _navController;
    private PrésentateurListeAventures _présentateurListeAventures;
    private TextView _texte1;
    private TextView _texte2;

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
        _texte1 =view.findViewById(R.id.titleAventure1);
        _texte2 = view.findViewById(R.id.titleAventure2);
        _présentateurListeAventures = new PrésentateurListeAventures(this);

        _présentateurListeAventures.récupererListe();

        _btnRetourner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _navController.navigate(R.id.vueMenuAventures);
                    }
                }
        );
    }


    @Override
    public void afficherListe(String[] tab) {

        _texte1.setText(tab[0]);
        _texte2.setText(tab[1]);
    }
}