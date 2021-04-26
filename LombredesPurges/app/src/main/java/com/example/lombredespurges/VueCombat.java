package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lombredespurges.domaine.entité.Personnage;
import com.example.lombredespurges.présentation.IContratPrésentateurVueCombat;
import com.example.lombredespurges.présentation.PrésentateurCombat;

import java.util.ArrayList;


public class VueCombat extends Fragment implements IContratPrésentateurVueCombat.IVueCombat {

    /**
     * Declaration des Attributs
     */
    Button btnContinuer;
    NavController navController;

    ImageButton btnDé;

    boolean tourJoueur = false;

    int resultatEndurance;

    TextView deroulementCombat;

    TextView coefAttaquePersonnage;
    TextView forcePersonnage;
    TextView agilitéPersonnage;
    TextView endurancePersonnage;
    TextView défencePersonnage;
    TextView nomPersonnage;

    TextView coefAttaqueEnnemi;
    TextView forceEnnemie;
    TextView agilitéEnnemie;
    TextView enduranceEnnemie;
    TextView défenceEnnemie;
    TextView nomEnnemi;

    ImageView raceImage;

    Bundle bundle;

    PrésentateurCombat présentateurCombat;


    public VueCombat() {
        // Required empty public constructor
    }

    public static VueCombat newInstance(String param1, String param2) {
        VueCombat fragment = new VueCombat();
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

        présentateurCombat = new PrésentateurCombat(this);
        présentateurCombat.creationEnnemie();
        btnContinuer = view.findViewById(R.id.btnContinuer);
        navController = Navigation.findNavController(view);
        btnContinuer.setVisibility(View.GONE);

        nomPersonnage = view.findViewById(R.id.nomPersonnage);
        présentateurCombat.getNomPersonnage();
        forcePersonnage = view.findViewById(R.id.forceheros);
        agilitéPersonnage = view.findViewById(R.id.agiliteheros);
        endurancePersonnage = view.findViewById(R.id.enduranceheros);
        présentateurCombat.getAttributsPersonnage();
        défencePersonnage = view.findViewById(R.id.defenceheros);
        coefAttaquePersonnage = view.findViewById(R.id.coefAttaquePersonnage);

        nomEnnemi = view.findViewById(R.id.nomEnnemi);
        présentateurCombat.getNomEnnemie();
        forceEnnemie = view.findViewById(R.id.forcepurge);
        agilitéEnnemie = view.findViewById(R.id.agilitepurge);
        enduranceEnnemie = view.findViewById(R.id.endurancepurge);
        présentateurCombat.getAttributsEnnemie();
        défenceEnnemie = view.findViewById(R.id.defencepurge);
        coefAttaqueEnnemi = view.findViewById(R.id.coefAttaqueEnnemi);

        deroulementCombat = view.findViewById(R.id.deroulementcombattexte);
        deroulementCombat.setText("Jouer le Dé pour déterminer l'attaquant");

        raceImage  = view.findViewById(R.id.imageView11);
        présentateurCombat.changerRace(getArguments().getString("race"));

        btnDé = view.findViewById(R.id.combatDé);
        btnDé.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        présentateurCombat.calculerCoefAttaque();
                        présentateurCombat.tourDAttaquer(tourJoueur);
                        présentateurCombat.comparerEndurance();
                    }
                }
        );

        btnContinuer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnContinuer.getText().equals("Continuer")){
                            présentateurCombat.chercherPersonage();
                        } else if (btnContinuer.getText().equals("Page titre")){
                            navController.navigate(R.id.pageTitre);
                        }
                    }
                }
        );
    }


    /**
     * La méthode permet que le nom reçu en parametre est affiché.
     *
     * @param unNom, (String) le nom du personnage.
     */
    @Override
    public void afficherNomPersonnage(String unNom) {
        nomPersonnage.setText(unNom.toUpperCase());
    }

    /**
     * La méthode permet que les attributs reçus en parametre sont affichés.
     *
     * @param attributs, les attribus du personnage.
     */
    @Override
    public void afficherAttributsPersonnage(ArrayList<Integer> attributs) {
        forcePersonnage.setText(String.valueOf(attributs.get(0)));
        agilitéPersonnage.setText(String.valueOf(attributs.get(1)));
        endurancePersonnage.setText(String.valueOf(attributs.get(2)));
    }

    /**
     * La méthode permet que le nom reçu en parametre est affiché.
     *
     * @param unNom, (String) le nom de l'ennemi.
     */
    @Override
    public void afficherNomEnnemie(String unNom) {
        nomEnnemi.setText(unNom.toUpperCase());
    }

    /**
     * La méthode permet que les attributs reçus en parametre sont affichés.
     *
     * @param attributs, les attribus de l'ennemi.
     */
    @Override
    public void afficherAttributsEnnemie(ArrayList<Integer> attributs) {
        forceEnnemie.setText(String.valueOf(attributs.get(0)));
        agilitéEnnemie.setText(String.valueOf(attributs.get(1)));
        enduranceEnnemie.setText(String.valueOf(attributs.get(2)));
    }

    /**
     * La méthode permet que les coeficientes d'attaque de l'ennemi et du personnage qui sont en parametre sont affichés, aussi
     * une parametre boolean pour savoir si c'est le tour du personnage ou pas.
     *
     * @param (coefAttaqueP, coestAttaqueE, resultatComparaison) les coeficientes d'attaque  du personnage et de l'ennemi aussi,
     *                                                           la conffirmation du tout du personnage.
     */
    @Override
    public void afficherCoefAttaque(int coefAttaqueP, int coefAttaqueE, boolean resultatComparaison) {
        coefAttaquePersonnage.setText(String.valueOf(coefAttaqueP));
        coefAttaqueEnnemi.setText(String.valueOf(coefAttaqueE));
        tourJoueur = resultatComparaison;
    }

    /**
     * La méthode permet realiser une action dans le tour d'attauque.
     *
     * @param accion, l'action à faire.
     */
    @Override
    public void gestionAccion(int accion) {
        présentateurCombat.faireAccionAttaquer(accion, tourJoueur);
    }

    /**
     * La méthode permet changer les textes qui affichetn le défence et endurance de l'ennemi.
     *
     * @param (defenceEnnemie,endurenceEnnemie), le defence et l'endurence de l'ennemi.
     */
    @Override
    public void setTextDefencéEndurenceEnnemie(int defenceEnnemie, int endurenceEnnemie) {
        défenceEnnemie.setText(String.valueOf(defenceEnnemie));
        enduranceEnnemie.setText(String.valueOf(endurenceEnnemie));
    }

    /**
     * La méthode permet changer les textes qui affichetn le défence et endurance du personnage.
     *
     * @param (defencePersonnage,endurencePersonnage), le defence et l'endurence du personnage.
     */
    @Override
    public void setTextDefencéEndurencePersonnage(int defencePersonnage, int endurencePersonnage) {
        défencePersonnage.setText(String.valueOf(defencePersonnage));
        endurancePersonnage.setText(String.valueOf(endurencePersonnage));
    }

    /**
     * La méthode permet faire l'action de tuer un ennemie.
     *
     * @param dommage, le dommage que l'ennemi a reçu.
     */
    @Override
    public void faireAction1(int dommage) {
        btnContinuer.setVisibility(View.VISIBLE);
        btnContinuer.setText("Continuer");
        btnDé.setVisibility(View.GONE);
        deroulementCombat.setText("Vous avez attaqué : " + dommage + " de dommage a été fait. L'ennemi est battu");
    }

    /**
     * La méthode permet faire l'action d'attaque un ennemie et qu'il recoit des dommages.
     *
     * @param dommage, le dommage que l'ennemi a reçu.
     */
    @Override
    public void faireAction2(int dommage) {
        deroulementCombat.setText("Vous avez attaqué : " + dommage + " de dommage a été fait. Jouer le dé pour prochain tour");
    }

    /**
     * La méthode permet faire l'action de tuer le personnage.
     *
     * @param dommage, le dommage que le personnage a reçu.
     */
    @Override
    public void faireAction3(int dommage) {
        btnContinuer.setVisibility(View.VISIBLE);
        btnContinuer.setText("Page titre");
        deroulementCombat.setText("Vous êtes attaqué : " + dommage + " de dommage a été fait. Vous êtes battu");
        btnDé.setVisibility(View.GONE);
    }

    /**
     * La méthode permet faire l'action d'attaque au personnage et qu'il recoit des dommages.
     *
     * @param dommage, le dommage que le personnage a reçu.
     */
    @Override
    public void faireAction4(int dommage) {
        deroulementCombat.setText("Vous êtes attaqué : " + dommage + " de dommage a été fait. Jouer le dé pour prochain tour");
    }

    /**
     * La méthode permet activer le bouton de Continuer ou de Page Titre en utilisant le resultat
     * d'endurance entre le personnage et l'ennemi.
     *
     * @param resultat, le resultat de l'endurance.
     */
    @Override
    public void resultatEndurance(int resultat) {
        if(resultatEndurance == 1){
            btnContinuer.setVisibility(View.VISIBLE);
            btnContinuer.setText("Page titre");
        }else if(resultatEndurance == 2){
            btnContinuer.setVisibility(View.VISIBLE);
            btnContinuer.setText("Continuer");
        }
    }

    /**
     * La méthode permet envoyer le personnage dans la prochaine vue de l'histoire.
     *
     * @param personnage, le personnage.
     */
    @Override
    public void envoiePersonnageDansProchaineVue(Personnage personnage) {
        bundle = new Bundle();
        bundle.putSerializable("Personnage",personnage);
        bundle.putBoolean("CombatFinit",true);
        bundle.putInt("ChoixPasséeAction", getArguments().getInt("ChoixPassée"));
        bundle.putInt("Étape",getArguments().getInt("ÉtapeVue"));

        bundle.putString("ChapitreCouranteAction",getArguments().getString("ChapitreCourante"));

        String race = getArguments().getString("race");

        if(race.equals("dino")){
            navController.navigate(R.id.chapitre_dino, bundle);
        }else if(race.equals("kaqchikam")){
            navController.navigate(R.id.chapitre_kachikam, bundle);
        }else if(race.equals("via")){
            navController.navigate(R.id.chapitre_via, bundle);
        }
    }

    /**
     * La méthode permet changer el type de race.
     *
     * @param race, le race choisit.
     */
    @Override
    public void actionChangerRace(int race) {
        raceImage.setImageDrawable(getResources().getDrawable(race));
    }
}