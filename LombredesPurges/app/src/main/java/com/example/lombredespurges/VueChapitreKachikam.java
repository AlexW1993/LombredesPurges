package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lombredespurges.domaine.entité.Personnage;

public class VueChapitreKachikam extends Fragment {

    /**
     * Declaration des Attributs
     */
    TextView texteContenueChapitre;
    TextView txtNumeroChapitre;
    TextView texteChapitre;
    Button btnChoix1;
    Button btnChoix2;
    Button btnChoix3;
    Button btnPageTitre;
    NavController navController;
    Personnage personnage;
    Bundle bundle;

    private int étapeCourant;
    private String chapitreCourante;

    public VueChapitreKachikam() {
        // Required empty public constructor
    }

    public static VueChapitreKachikam newInstance(String param1, String param2) {
        VueChapitreKachikam fragment = new VueChapitreKachikam();
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
        return inflater.inflate(R.layout.chapitre_histoire_kachikam, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        txtNumeroChapitre = view.findViewById(R.id.numeroChapitreKa);
        texteChapitre = view.findViewById(R.id.texteChapitreKa);
        texteContenueChapitre = view.findViewById(R.id.contenueChapitreKa);

        btnPageTitre = view.findViewById(R.id.buttonMenuKa);
        btnPageTitre.setVisibility(View.GONE);

        personnage = (Personnage) getArguments().getSerializable("Personnage");
        bundle = new Bundle();
        bundle.putSerializable("Personnage", personnage);
        bundle.putString("race", "kaqchikam");


        btnChoix1 = view.findViewById(R.id.buttonChoix1Ka);
        btnChoix2 = view.findViewById(R.id.buttonChoix2Ka);
        btnChoix3 = view.findViewById(R.id.buttonChoix3Ka);

        chapitreCourante = getArguments().getString("ChapitreCouranteAction");
        étapeCourant = detectionÉtape(getArguments());

        gestionAffichageDesChapitres(getArguments().getInt("ChoixPasséeAction"));

        btnChoix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                étapeCourant++;
                gestionAffichageDesChapitres(1);
            }
        });


        btnChoix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                étapeCourant++;
                gestionAffichageDesChapitres(2);
            }
        });

        btnChoix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                étapeCourant++;
                gestionAffichageDesChapitres(3);
            }
        });

        btnPageTitre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.pageTitre);
            }
        });

    }

    private int detectionÉtape(Bundle unBundle){
        int etape = unBundle.getInt("Étape");

        if (etape == 0 ){
            return 1;
        }else{
            return etape;
        }
    }

    private void gestionAffichageDesChapitres(int choix){


        if(étapeCourant == 1){
            gestionÉtape1();
        }else if(étapeCourant == 2){
            gestionÉtape2(choix);
        }else if(étapeCourant == 3){
            gestionÉtape3(choix);
        }else if(étapeCourant == 4){
            gestionÉtape4(choix);
        }else if(étapeCourant == 5){
            gestionÉtape5(choix);
        }
    }


    private void gestionÉtape1(){
        txtNumeroChapitre.setText("1");
        texteContenueChapitre.setText(R.string.chapitre0Kachikam);
        btnChoix1.setText(R.string.choix0_1Kachikam);
        btnChoix2.setText(R.string.choix0_2Kachikam);
        btnChoix3.setText(R.string.choix0_3Kachikam);
        chapitreCourante = "1";
    }

    private void gestionÉtape2(int choix){

        if(choix == 1){
            txtNumeroChapitre.setText("2");
            texteContenueChapitre.setText(R.string.chapitre1Kachikam);
            btnChoix1.setText(R.string.choix1_1Kachikam);
            btnChoix2.setText(R.string.choix1_2Kachikam);
            btnChoix3.setText(R.string.choix1_3Kachikam);
            chapitreCourante = "2_1";
        }else if(choix == 2){
            boolean combatFinit = getArguments().getBoolean("CombatFinit");
            if (!combatFinit) {
                bundle.putInt("ÉtapeVue", étapeCourant);
                bundle.putInt("ChoixPassée", choix);
                bundle.putString("ChapitreCourante",chapitreCourante);
                navController.navigate(R.id.combat, bundle);
            } else {
                txtNumeroChapitre.setText("2");
                texteContenueChapitre.setText(R.string.chapitre2Kachikam);
                btnChoix1.setText(R.string.choix2_1Kachikam);
                btnChoix2.setText(R.string.choix2_2Kachikam);
                btnChoix3.setText(R.string.choix2_3Kachikam);
                chapitreCourante = "2_2";
            }
        }else if (choix == 3){
            txtNumeroChapitre.setText("2");
            texteContenueChapitre.setText(R.string.chapitre3Kachikam);
            btnChoix1.setText(R.string.choix3_1Kachikam);
            btnChoix2.setText(R.string.choix3_2Kachikam);
            btnChoix3.setText(R.string.choix3_3Kachikam);
            chapitreCourante = "2_3";
        }
    }

    private void gestionÉtape3(int choix){

        /*
        2.1.1 - 3.1
        2.2.1 - 3.1
        2.3.1 - 3.6+++++++

        2.1.2 - 3.2
        2.2.2 - 3.2
        2.3.2 - 3.5

        2.1.3 - 3.3
        2.2.3 - 3.3
        2.3.3 - 3.4

         */
        if(choix == 1)  {

            if (chapitreCourante.equals("2_1") || chapitreCourante.equals("2_2")){
                txtNumeroChapitre.setText("3");
                texteContenueChapitre.setText(R.string.chapitre4Kachikam);
                btnChoix1.setText(R.string.choix4_1Kachikam);
                btnChoix2.setText(R.string.choix4_2Kachikam);
                btnChoix3.setText(R.string.choix4_3Kachikam);
                chapitreCourante = "3_1";


            }else if(chapitreCourante.equals("2_3")){
                txtNumeroChapitre.setText("3");
                texteContenueChapitre.setText(R.string.chapitre9Kachikam);
                btnChoix1.setText(R.string.choix9_1Kachikam);
                btnChoix2.setText(R.string.choix9_2Kachikam);
                btnChoix3.setText(R.string.choix9_3Kachikam);
                chapitreCourante = "3_6";
            }

        }else if(choix == 2){
            if(chapitreCourante.equals("2_1") || chapitreCourante.equals("2_2")){
                txtNumeroChapitre.setText("3");
                texteContenueChapitre.setText(R.string.chapitre5Kachikam);
                btnChoix1.setText(R.string.choix5_1Kachikam);
                btnChoix2.setText(R.string.choix5_2Kachikam);
                btnChoix3.setText(R.string.choix5_3Kachikam);
                chapitreCourante = "3_2";
            }else if(chapitreCourante.equals("2_3")){
                txtNumeroChapitre.setText("3");
                texteContenueChapitre.setText(R.string.chapitre8Kachikam);
                btnChoix1.setText(R.string.choix8_1Kachikam);
                btnChoix2.setText(R.string.choix8_2Kachikam);
                btnChoix3.setText(R.string.choix8_3Kachikam);
                chapitreCourante = "3_5";
            }

        }else if(choix == 3){
            if(chapitreCourante.equals("2_1") || chapitreCourante.equals("2_2")){
                cheminFinal(R.string.dommage,R.string.chapitre6Kachikam);
            }else if(chapitreCourante.equals("2_3")){
                cheminFinal(R.string.dommage,R.string.chapitre7Kachikam);
            }
        }
    }

    /*
    3.1.1 - 4.3
    3.2.1 - 4.3
    3.5.1 - 4.3
    3.6.1 - 4.3 FIN1

    3.1.2 - 4.1 COMBAT
    3.2.2 - 4.1 COMBAT
    3.5.2 - 4.1 COMBAT
    3.6.2 - 4.1 COMBAT

    3.1.3 - 4.2 COMBAT
    3.2.3 - 4.2 COMBAT
    3.5.3 - 4.2 COMBAT
    3.6.3 - 4.2 COMBAT
     */

    private void gestionÉtape4(int choix){
        if(choix == 1){
            cheminFinal(R.string.dommage,R.string.chapitre12Kachikam);
        }else if(choix == 2) {
            boolean combatFinit = getArguments().getBoolean("CombatFinit");
            if (!combatFinit) {
                bundle.putInt("ÉtapeVue", étapeCourant);
                bundle.putInt("ChoixPassée", choix);
                bundle.putString("ChapitreCourante",chapitreCourante);
                navController.navigate(R.id.combat, bundle);
            } else {
                txtNumeroChapitre.setText("4");
                texteContenueChapitre.setText(R.string.chapitre10Kachikam);
                btnChoix1.setText(R.string.choix10_1Kachikam);
                btnChoix2.setText(R.string.choix10_2Kachikam);
                btnChoix3.setText(R.string.choix10_3Kachikam);
                chapitreCourante = "4_1";
            }
        }else if(choix == 3){
            boolean combatFinit = getArguments().getBoolean("CombatFinit");
            if (!combatFinit) {
                bundle.putInt("ÉtapeVue", étapeCourant);
                bundle.putInt("ChoixPassée", choix);
                bundle.putString("ChapitreCourante",chapitreCourante);
                navController.navigate(R.id.combat, bundle);
            } else {
                txtNumeroChapitre.setText("4");
                texteContenueChapitre.setText(R.string.chapitre11Kachikam);
                btnChoix1.setText(R.string.choix11_1Kachikam);
                btnChoix2.setText(R.string.choix11_2Kachikam);
                btnChoix3.setText(R.string.choix11_3Kachikam);
                chapitreCourante = "4_2";
            }
        }
    }

    /*
    4.1.1 - fin1
    4.2.1 - fin5

    4.1.2 - COMBAT , fin2
    4.2.2 - COMBAT - fin6

    4.1.3 - fin3
    4.3.3 - fin7
     */

    private void gestionÉtape5(int choix){
        if(choix == 1){
            if(chapitreCourante.equals("4_1")){
                cheminFinal(R.string.dommage,R.string.chapitre12Kachikam);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.bravo,R.string.chapitre15Kachikam);
            }
        }else if(choix == 2){
            if(chapitreCourante.equals("4_1")){
                boolean combatFinit = getArguments().getBoolean("CombatFinit");
                if (!combatFinit) {
                    bundle.putInt("ÉtapeVue", étapeCourant);
                    bundle.putInt("ChoixPassée", choix);
                    bundle.putString("ChapitreCourante",chapitreCourante);
                    navController.navigate(R.id.combat, bundle);
                } else {
                    cheminFinal(R.string.bravo,R.string.chapitre13Kachikam);
                }

            }else if(chapitreCourante.equals("4_2")){
                boolean combatFinit = getArguments().getBoolean("CombatFinit");
                if (!combatFinit) {
                    bundle.putInt("ÉtapeVue", étapeCourant);
                    bundle.putInt("ChoixPassée", choix);
                    bundle.putString("ChapitreCourante",chapitreCourante);
                    navController.navigate(R.id.combat, bundle);
                } else {
                    cheminFinal(R.string.dommage,R.string.chapitre16Kachikam);
                }
            }
        }else if(choix == 3){
            if(chapitreCourante.equals("4_1")) {
                cheminFinal(R.string.dommage, R.string.chapitre14Kachikam);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.dommage,R.string.chapitre17Kachikam);
            }
        }

    }

    public void cheminFinal(int _texteFin, int texte){
        String nom = personnage.get_nom();
        txtNumeroChapitre.setText(nom);
        texteChapitre.setText(_texteFin);
        texteContenueChapitre.setText(texte);
        btnChoix1.setVisibility(View.GONE);
        btnChoix2.setVisibility(View.GONE);
        btnChoix3.setVisibility(View.GONE);
        btnPageTitre.setVisibility(View.VISIBLE);

    }
}
