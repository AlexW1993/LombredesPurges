package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lombredespurges.modèle.Personnage;

public class ChapitreVia extends Fragment {

    /**
     * Declaration des Attributs
     */
    ImageView raceChap;
    TextView texteChapitre;
    TextView texteTitre;
    TextView texteTitre2;
    Button choix1;
    Button choix2;
    Button choix3;
    Button pageTitre;
    NavController navController;
    Personnage personnage;
    Bundle bundle;

    public ChapitreVia() {
        // Required empty public constructor
    }

    public static ChapitreVia newInstance(String param1, String param2) {
        ChapitreVia fragment = new ChapitreVia();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void changerImage() {
        String nomRace = getArguments().getString("nomRace");

        if (nomRace.equals("via")) {
            raceChap.setImageDrawable(getResources().getDrawable(R.drawable.via));
        } else if (nomRace.equals("kaqchikam")) {
            raceChap.setImageDrawable(getResources().getDrawable(R.drawable.kaqchikam));
        } else if (nomRace.equals("dino")) {
            raceChap.setImageDrawable(getResources().getDrawable(R.drawable.dinoh));
        }
    }


    public void choixChemin(String _numeroChapitre, int texte,int choixUn,int choixDeux,int choixTrois){
        texteTitre.setText(_numeroChapitre);
        texteChapitre.setText(texte);
        choix1.setText(choixUn);
        choix2.setText(choixDeux);
        choix3.setText(choixTrois);
    }

    public void cheminFinal(int _texteFin, int texte){
        String nom = getArguments().getString("nom");
        texteTitre.setText(nom);
        texteTitre2.setText(_texteFin);
        texteChapitre.setText(texte);
        choix1.setVisibility(View.GONE);
        choix2.setVisibility(View.GONE);
        choix3.setVisibility(View.GONE);
        pageTitre.setVisibility(View.VISIBLE);
        pageTitre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.pageTitre);
            }
        });
    }

    public void gestionChapitre2() {
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //*******COMBAT*****//
                navController.navigate(R.id.combat, bundle);
                //***** COMBAT*****//
                choixChemin("3",R.string.chapitre3_1Via,R.string.choix1_3_1Via,R.string.choix2_3_1Via,R.string.choix3_3_1Via);
                gestionChapitre4();

            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixChemin("3",R.string.chapitre3_2Via,R.string.choix1_3_2Via,R.string.choix2_3_2Via,R.string.choix3_3_2Via);
                gestionChapitre4();

            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheminFinal(R.string.dommage,R.string.chapitre3_3Via);
            }
        });

    }



    public void gestionChapitre4(){
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixChemin("4",R.string.chapitre4_1Via,R.string.choix1_4_1Via,R.string.choix2_4_1Via,R.string.choix3_4_1Via);
                choix1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cheminFinal(R.string.dommage,R.string.chapitrefin4Via);
                    }
                });
                choix2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cheminFinal(R.string.bravo,R.string.chapitrefin2Via);
                    }
                });
                choix3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cheminFinal(R.string.bravo,R.string.chapitrefin3Via);
                    }
                });
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //*******COMBAT*****//
                navController.navigate(R.id.combat, bundle);
                //***** COMBAT*****//
                choixChemin("4",R.string.chapitre4_2Via,R.string.choix1_4_2Via,R.string.choix2_4_2Via,R.string.choix3_4_2Via);
                choix1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cheminFinal(R.string.dommage,R.string.chapitrefin5Via);
                    }
                });
                choix2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cheminFinal(R.string.bravo,R.string.chapitrefin2Via);
                    }
                });
                choix3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cheminFinal(R.string.dommage,R.string.chapitrefin6Via);
                    }
                });
            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheminFinal(R.string.dommage,R.string.chapitrefin1Via);
            }
        });
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

        raceChap = view.findViewById(R.id.raceChap2);
        texteTitre = view.findViewById(R.id.texteTitre2);
        texteTitre2 = view.findViewById(R.id.texteTitre6);
        texteChapitre = view.findViewById(R.id.texteChapitre2);
        choix1 = view.findViewById(R.id.buttonChoixVia1);
        choix2 = view.findViewById(R.id.buttonChoixVia2);
        choix3 = view.findViewById(R.id.buttonChoixVia3);
        pageTitre = view.findViewById(R.id.buttonMenu2);
        navController = Navigation.findNavController(view);
        changerImage();
        texteTitre.setText("1");
        texteChapitre.setText(R.string.chapitre1Via);
        choix1.setText(R.string.choix1_1Via);
        choix2.setText(R.string.choix2_1Via);
        choix3.setText(R.string.choix3_1Via);
        choix1.setVisibility(View.VISIBLE);
        choix2.setVisibility(View.VISIBLE);
        choix3.setVisibility(View.VISIBLE);
        pageTitre.setVisibility(View.GONE);

        personnage = (Personnage) getArguments().getSerializable("Personnage");
        bundle = new Bundle();
        bundle.putSerializable("Personnage", personnage);

        choix1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          choixChemin("2",R.string.chapitre2_1Via,R.string.choix1_2_1Via,R.string.choix2_2_1Via,R.string.choix3_2_1Via);
                                          gestionChapitre2();
                                      }
                                  }
        );

        choix2.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          choixChemin("2", R.string.chapitre2_2Via, R.string.choix1_2_2Via, R.string.choix2_2_2Via, R.string.choix3_2_2Via);
                                          gestionChapitre2();
                                      }
                                  }
        );
        choix3.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          choixChemin("2",R.string.chapitre2_3Via,R.string.choix1_2_3Via,R.string.choix2_2_3Via,R.string.choix3_2_3Via);
                                          choix1.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  //*******COMBAT*****//
                                                  navController.navigate(R.id.combat, bundle);
                                                  //***** COMBAT*****//
                                                  choixChemin("3",R.string.chapitre3_6Via,R.string.choix1_3_6Via,R.string.choix2_3_6Via,R.string.choix3_3_6Via);
                                                  gestionChapitre4();
                                              }
                                          });
                                          choix2.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  choixChemin("3",R.string.chapitre3_5Via,R.string.choix1_3_5Via,R.string.choix2_3_5Via,R.string.choix3_3_5Via);
                                                  gestionChapitre4();
                                              }
                                          });
                                          choix3.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  cheminFinal(R.string.dommage,R.string.chapitre3_4Via);
                                              }
                                          });
                                      }
                                  }
        );
    }


}
