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

public class VueChapitreVia extends Fragment {

    /**
     * Declaration des Attributs
     */
    private TextView texteContenueChapitre;
    private TextView txtNumeroChapitre;
    private TextView texteChapitre;
    private Button btnChoix1;
    private Button btnChoix2;
    private Button btnChoix3;
    private Button btnPageTitre;
    private NavController navController;
    private Personnage personnage;
    private String nomRace;
    private Bundle bundle;

    private int étapeCourant;
    private String chapitreCourante;

    public VueChapitreVia() {
        // Required empty public constructor
    }

    public static VueChapitreVia newInstance(String param1, String param2) {
        VueChapitreVia fragment = new VueChapitreVia();
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
        return inflater.inflate(R.layout.chapitre_histoire_via, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        txtNumeroChapitre = view.findViewById(R.id.numeroChapitreVIA);
        texteChapitre = view.findViewById(R.id.texteChapitreVIA);
        texteContenueChapitre = view.findViewById(R.id.contenueChapitreVIA);

        btnPageTitre = view.findViewById(R.id.buttonMenuVIA);
        btnPageTitre.setVisibility(View.GONE);

        nomRace = getArguments().getString("race");
        personnage = (Personnage) getArguments().getSerializable("Personnage");
        bundle = new Bundle();
        bundle.putSerializable("Personnage", personnage);
        bundle.putString("race", "via");


        btnChoix1 = view.findViewById(R.id.buttonChoixVia1);
        btnChoix2 = view.findViewById(R.id.buttonChoixVia2);
        btnChoix3 = view.findViewById(R.id.buttonChoixVia3);

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
        texteContenueChapitre.setText(R.string.chapitre1Via);
        btnChoix1.setText(R.string.choix1_1Via);
        btnChoix2.setText(R.string.choix1_2Via);
        btnChoix3.setText(R.string.choix1_3Via);
        chapitreCourante = "1";
    }

    private void gestionÉtape2(int choix){

        if(choix == 1){
            txtNumeroChapitre.setText("2");
            texteContenueChapitre.setText(R.string.chapitre2_1Via);
            btnChoix1.setText(R.string.choix2_1_1Via);
            btnChoix2.setText(R.string.choix2_1_2Via);
            btnChoix3.setText(R.string.choix2_1_3Via);
            chapitreCourante = "2_1";
        }else if(choix == 2){
            txtNumeroChapitre.setText("2");
            texteContenueChapitre.setText(R.string.chapitre2_2Via);
            btnChoix1.setText(R.string.choix2_2_1Via);
            btnChoix2.setText(R.string.choix2_2_2Via);
            btnChoix3.setText(R.string.choix2_2_3Via);
            chapitreCourante = "2_2";
        }else if (choix == 3){
            txtNumeroChapitre.setText("2");
            texteContenueChapitre.setText(R.string.chapitre2_3Via);
            btnChoix1.setText(R.string.choix2_3_1Via);
            btnChoix2.setText(R.string.choix2_3_2Via);
            btnChoix3.setText(R.string.choix2_3_3Via);
            chapitreCourante = "2_3";
        }
    }

    private void gestionÉtape3(int choix){

        if(choix == 1)  {

            if (chapitreCourante.equals("2_1") || chapitreCourante.equals("2_2")){
                boolean combatFinit = getArguments().getBoolean("CombatFinit");
                if (!combatFinit) {
                    bundle.putInt("ÉtapeVue", étapeCourant);
                    bundle.putInt("ChoixPassée", 1);
                    bundle.putString("ChapitreCourante",chapitreCourante);
                    navController.navigate(R.id.combat, bundle);
                } else {
                    txtNumeroChapitre.setText("3");
                    texteContenueChapitre.setText(R.string.chapitre3_1Via);
                    btnChoix1.setText(R.string.choix3_1_1Via);
                    btnChoix2.setText(R.string.choix3_1_2Via);
                    btnChoix3.setText(R.string.choix3_1_3Via);
                    chapitreCourante = "3_1";
                }
            }else if(chapitreCourante.equals("2_3")){
                boolean combatFinit = getArguments().getBoolean("CombatFinit");
                if (!combatFinit) {
                    bundle.putInt("ÉtapeVue", étapeCourant);
                    bundle.putInt("ChoixPassée", 1);
                    bundle.putString("ChapitreCourante", chapitreCourante);
                    navController.navigate(R.id.combat, bundle);
                } else {
                    txtNumeroChapitre.setText("3");
                    texteContenueChapitre.setText(R.string.chapitre3_6Via);
                    btnChoix1.setText(R.string.choix3_6_1Via);
                    btnChoix2.setText(R.string.choix3_6_2Via);
                    btnChoix3.setText(R.string.choix3_6_3Via);
                    chapitreCourante = "3_6";
                }
            }

        }else if(choix == 2){
            if(chapitreCourante.equals("2_1") || chapitreCourante.equals("2_2")){
                txtNumeroChapitre.setText("3");
                texteContenueChapitre.setText(R.string.chapitre3_2Via);
                btnChoix1.setText(R.string.choix3_2_1Via);
                btnChoix2.setText(R.string.choix3_2_2Via);
                btnChoix3.setText(R.string.choix3_2_3Via);
                chapitreCourante = "3_2";
            }else if(chapitreCourante.equals("2_3")){
                txtNumeroChapitre.setText("3");
                texteContenueChapitre.setText(R.string.chapitre3_5Via);
                btnChoix1.setText(R.string.choix3_5_1Via);
                btnChoix2.setText(R.string.choix3_5_2Via);
                btnChoix3.setText(R.string.choix3_5_3Via);
                chapitreCourante = "3_5";
            }

        }else if(choix == 3){
            if(chapitreCourante.equals("2_1") || chapitreCourante.equals("2_2")){
                cheminFinal(R.string.dommage,R.string.chapitre3_3Via);
            }else if(chapitreCourante.equals("2_3")){
                cheminFinal(R.string.dommage,R.string.chapitre3_4Via);
            }
        }
    }

    private void gestionÉtape4(int choix){
        if(choix == 1){
            cheminFinal(R.string.dommage,R.string.chapitrefin1Via);
        }else if(choix == 2) {
            txtNumeroChapitre.setText("4");
            texteContenueChapitre.setText(R.string.chapitre4_1Via);
            btnChoix1.setText(R.string.choix4_1_1Via);
            btnChoix2.setText(R.string.choix4_1_2Via);
            btnChoix3.setText(R.string.choix4_1_3Via);
            chapitreCourante = "4_1";
        }else if(choix == 3){
            txtNumeroChapitre.setText("4");
            texteContenueChapitre.setText(R.string.chapitre4_2Via);
            btnChoix1.setText(R.string.choix4_2_1Via);
            btnChoix2.setText(R.string.choix4_2_2Via);
            btnChoix3.setText(R.string.choix4_2_3Via);
            chapitreCourante = "4_2";
        }
    }

    private void gestionÉtape5(int choix){
        if(choix == 1){
            if(chapitreCourante.equals("4_1")){
                cheminFinal(R.string.dommage,R.string.chapitrefin4Via);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.bravo,R.string.chapitrefin5Via);
            }
        }else if(choix == 2){
            if(chapitreCourante.equals("4_1")){
                cheminFinal(R.string.bravo,R.string.chapitrefin2Via);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.dommage,R.string.chapitrefin2Via);
            }
        }else if(choix == 3){
            if(chapitreCourante.equals("4_1")) {
                cheminFinal(R.string.dommage, R.string.chapitrefin3Via);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.dommage,R.string.chapitrefin6Via);
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
