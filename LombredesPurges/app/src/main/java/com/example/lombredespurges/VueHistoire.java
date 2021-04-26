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
import com.example.lombredespurges.présentation.IContratPrésentateurVueHistoires;
import com.example.lombredespurges.présentation.PrésentateurHistoires;

public class VueHistoire extends Fragment implements IContratPrésentateurVueHistoires.IVueHistoire {

    private TextView texteContenueChapitre;
    private TextView txtNumeroChapitre;
    private TextView texteChapitre;
    private Button btnChoix1;
    private Button btnChoix2;
    private Button btnChoix3;
    private Button btnPageTitre;
    private NavController navController;
    private Personnage personnage;
    private Bundle bundle;

    private Button[] buttons = new Button[3];

    private int étapeCourant;
    private String chapitreCourante;


    private int numéroChapitreCourant;
    private boolean finalitéCombat;

    PrésentateurHistoires présentateurHistoires;

    public VueHistoire() {
        // Required empty public constructor
    }

    public static VueHistoire newInstance(String param1, String param2) {
        VueHistoire fragment = new VueHistoire();
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
        return inflater.inflate(R.layout.chapitre_histoire_dino, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        //String nomRace = getArguments().getString("race");
        présentateurHistoires = new PrésentateurHistoires(this);

        txtNumeroChapitre = view.findViewById(R.id.NumeroChapitre);
        texteChapitre = view.findViewById(R.id.texteChapitre);
        texteContenueChapitre = view.findViewById(R.id.contenueChapitre);

        btnPageTitre = view.findViewById(R.id.buttonMenu);
        btnPageTitre.setVisibility(View.GONE);

        btnChoix1 = view.findViewById(R.id.buttonChoix1);
        btnChoix2 = view.findViewById(R.id.buttonChoix2);
        btnChoix3 = view.findViewById(R.id.buttonChoix3);


        présentateurHistoires.gestionChapitre(-1);

        //personnage = (Personnage) getArguments().getSerializable("Personnage");
        bundle = new Bundle();

        //afficherAventure(nomRace);

        //chapitreCourante = getArguments().getString("ChapitreCouranteAction");
        //étapeCourant = detectionÉtape(getArguments());


        //gestionAffichageDesChapitres(getArguments().getInt("ChoixPasséeAction"));

        btnChoix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurHistoires.gestionChapitre(0);
                //
                /*présentateurHistoires.déterminerCombat(numéroChapitreCourant, finalitéCombat);
                présentateurHistoires.gestionChapitres(numéroChapitreCourant);*/
            }
        });


        btnChoix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurHistoires.gestionChapitre(1);
                /*présentateurHistoires.déterminerCombat(numéroChapitreCourant, finalitéCombat);
                présentateurHistoires.gestionChapitres(numéroChapitreCourant);*/
            }
        });

        btnChoix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                présentateurHistoires.gestionChapitre(2);
                /*présentateurHistoires.déterminerCombat(numéroChapitreCourant, finalitéCombat);
                présentateurHistoires.gestionChapitres(numéroChapitreCourant);*/
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


    /*private void gestionÉtape1(){
        présentateurHistoires.getNumeroChapitre(0);
        texteContenueChapitre.setText(R.string.chapitre0Dino);
        btnChoix1.setText(R.string.choix0_1);
        btnChoix2.setText(R.string.choix0_2);
        btnChoix3.setText(R.string.choix0_3);
        chapitreCourante = "1";
    }

    private void gestionÉtape2(int choix){

        if(choix == 1){
            présentateurHistoires.getNumeroChapitre(1);
            texteContenueChapitre.setText(R.string.chapitre1Dino);
            btnChoix1.setText(R.string.choix1_1);
            btnChoix2.setText(R.string.choix1_2);
            btnChoix3.setText(R.string.choix1_3);
            chapitreCourante = "2_1";
        }else if(choix == 2){
            présentateurHistoires.getNumeroChapitre(2);
            texteContenueChapitre.setText(R.string.chapitre2Dino);
            btnChoix1.setText(R.string.choix2_1);
            btnChoix2.setText(R.string.choix2_2);
            btnChoix3.setText(R.string.choix2_3);
            chapitreCourante = "2_2";
        }else if (choix == 3){
            présentateurHistoires.getNumeroChapitre(3);
            texteContenueChapitre.setText(R.string.chapitre3Dino);
            btnChoix1.setText(R.string.choix3_1);
            btnChoix2.setText(R.string.choix3_2);
            btnChoix3.setText(R.string.choix3_3);
            chapitreCourante = "2_3";
        }
    }

    private void gestionÉtape3(int choix){

        if(choix == 1) {

            if (chapitreCourante.equals("2_1") || chapitreCourante.equals("2_2")) {
                boolean combatFinit = getArguments().getBoolean("CombatFinit");
                if (!combatFinit) {
                    bundle.putInt("ÉtapeVue", étapeCourant);
                    bundle.putInt("ChoixPassée", 1);
                    bundle.putString("ChapitreCourante", chapitreCourante);
                    navController.navigate(R.id.combat, bundle);
                } else {
                    txtNumeroChapitre.setText("3");
                    texteContenueChapitre.setText(R.string.chapitre3_1Dino);
                    btnChoix1.setText(R.string.choix4_1);
                    btnChoix2.setText(R.string.choix4_2);
                    btnChoix3.setText(R.string.choix4_3);
                    chapitreCourante = "3_1";
                }
            } else if (chapitreCourante.equals("2_3")) {
                boolean combatFinit = getArguments().getBoolean("CombatFinit");
                if (!combatFinit) {
                    bundle.putInt("ÉtapeVue", étapeCourant);
                    bundle.putInt("ChoixPassée", 1);
                    bundle.putString("ChapitreCourante", chapitreCourante);
                    navController.navigate(R.id.combat, bundle);
                } else {
                    txtNumeroChapitre.setText("3");
                    texteContenueChapitre.setText(R.string.chapitre3_6Dino);
                    btnChoix1.setText(R.string.choix9_1);
                    btnChoix2.setText(R.string.choix9_2);
                    btnChoix3.setText(R.string.choix9_3);
                    chapitreCourante = "3_6";
                }
            }
        }

    private void gestionÉtape5(int choix){
        if(choix == 1){
            if(chapitreCourante.equals("4_1")){
                cheminFinal(R.string.dommage,R.string.chapitre15Dino);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.bravo,R.string.chapitre16Dino);
            }
        }else if(choix == 2){
            if(chapitreCourante.equals("4_1")){
                cheminFinal(R.string.bravo,R.string.chapitre13Dino);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.dommage,R.string.chapitre17Dino);
            }
        }else if(choix == 3){
            if(chapitreCourante.equals("4_1")) {
                cheminFinal(R.string.dommage, R.string.chapitre14Dino);
            }else if(chapitreCourante.equals("4_2")){
                cheminFinal(R.string.dommage,R.string.chapitre18Dino);
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

    }*/







    /*@Override
    public void afficherProchainChapitre(int _prochainChapitre) {

    }
*/
    /*@Override
    public void faireCombat(){
        bundle.putInt("ÉtapeVue", numéroChapitreCourant);
        bundle.putInt("ChoixPassée", 1);
        bundle.putString("ChapitreCourante",chapitreCourante);
        navController.navigate(R.id.combat, bundle);
    }*/


    public boolean finalitéCombat() {
        boolean combatFinit = getArguments().getBoolean("CombatFinit");
        return combatFinit;
    }




    ///////////////

    @Override
    public void afficherAventure(int numeroChapitre, int idContenueChapitre,int idChoix1,int idChoix2,int idChoix3) {
        txtNumeroChapitre.setText(String.valueOf(numeroChapitre));
        texteContenueChapitre.setText(idContenueChapitre);
        btnChoix1.setText(idChoix1);
        btnChoix2.setText(idChoix2);
        btnChoix3.setText(idChoix3);
    }



    public void afficherFinJeu(int numeroChapitre, int idContenueChapitre){


        txtNumeroChapitre.setText(String.valueOf(numeroChapitre));
        texteContenueChapitre.setText(idContenueChapitre);


        btnChoix1.setVisibility(View.GONE);
        btnChoix2.setVisibility(View.GONE);
        btnChoix3.setVisibility(View.GONE);

        btnPageTitre.setVisibility(View.VISIBLE);

    }

    @Override
    public void passerAuCombat(){
        navController.navigate(R.id.combat);
    }





    /*
    private TextView texteContenueChapitre;
    private TextView txtNumeroChapitre;
    private TextView texteChapitre;
    private Button btnChoix1;
    private Button btnChoix2;
    private Button btnChoix3;
    private Button btnPageTitre;
    private NavController navController;
    private Personnage personnage;
    private Bundle bundle;

    private int étapeCourant;
    private String chapitreCourante;


    private int numéroChapitreCourant;
    private boolean finalitéCombat;

    PrésentateurHistoires présentateurHistoires;
     */

}