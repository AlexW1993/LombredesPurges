package com.example.lombredespurges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

    public VueChapitreKachikam() {
        // Required empty public constructor
    }

    public static VueChapitreKachikam newInstance(String param1, String param2) {
        VueChapitreKachikam fragment = new VueChapitreKachikam();
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

    public void gestionChapitre3(){
        choixChemin("3",R.string.chapitre3_1Kachikam,R.string.choix1_3_1Kachikam,R.string.choix2_3_1Kachikam,R.string.choix3_3_1Kachikam);
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheminFinal(R.string.dommage,R.string.chapitrefin1Kachikam);
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //*******COMBAT*****//
                navController.navigate(R.id.combat);
                //***** COMBAT*****//
                gestionChapitre4_1();
            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //*******COMBAT*****//
                navController.navigate(R.id.combat);
                //***** COMBAT*****//
                gestionChapitre4_2();                                    }
        });
    }

    public void gestionChapitre4_1() {
        //*******COMBAT*****//
        navController.navigate(R.id.combat);
        //***** COMBAT*****//
        choixChemin("4",R.string.chapitre4_1Kachikam,R.string.choix1_4_1Kachikam,R.string.choix2_4_1Kachikam,R.string.choix3_4_1Kachikam);
        choix1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal(R.string.dommage, R.string.chapitrefin1Kachikam);
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //*******COMBAT*****//
                navController.navigate(R.id.combat, bundle);
                //***** COMBAT*****//
                cheminFinal(R.string.bravo, R.string.chapitrefin2Kachikam);
            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal(R.string.dommage, R.string.chapitrefin3Kachikam);
            }
        });
    }

    public void gestionChapitre4_2(){
        //*******COMBAT*****//
        navController.navigate(R.id.combat);
        //***** COMBAT*****//
        choixChemin("4",R.string.chapitre4_2Kachikam,R.string.choix1_4_2Kachikam,R.string.choix2_4_2Kachikam,R.string.choix3_4_2Kachikam);
        choix1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal(R.string.bravo,R.string.chapitrefin4Kachikam);
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal(R.string.dommage,R.string.chapitrefin5Kachikam);
            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal(R.string.dommage,R.string.chapitrefin6Kachikam);
                texteChapitre.setTextSize(16);
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
        return inflater.inflate(R.layout.chapitre_histoire_kachikam, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        raceChap = view.findViewById(R.id.raceChap3);
        texteTitre = view.findViewById(R.id.texteTitre3);
        texteTitre2 = view.findViewById(R.id.texteTitre5);
        texteChapitre = view.findViewById(R.id.texteChapitre3);
        choix1 = view.findViewById(R.id.buttonChoixka1);
        choix2 = view.findViewById(R.id.buttonChoixka2);
        choix3 = view.findViewById(R.id.buttonChoixka3);
        pageTitre = view.findViewById(R.id.buttonMenu3);
        navController = Navigation.findNavController(view);
        changerImage();
        texteTitre.setText("1");
        texteChapitre.setText(R.string.chapitre1Kachikam);
        choix1.setText(R.string.choix1_1Kachikam);
        choix2.setText(R.string.choix2_1Kachikam);
        choix3.setText(R.string.choix3_1Kachikam);
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
                                          choixChemin("2",R.string.chapitre2_1Kachikam,R.string.choix1_2_1Kachikam,R.string.choix2_2_1Kachikam,R.string.choix3_2_1Kachikam);
                                          choix1.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  gestionChapitre3();
                                              }
                                          });
                                          choix2.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  gestionChapitre3();
                                              }
                                          });
                                          choix3.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  cheminFinal(R.string.dommage,R.string.chapitre3_3Kachikam);
                                              }
                                          });

                                      }
                                  }
        );

        choix2.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          //*******COMBAT*****//
                                          navController.navigate(R.id.combat, bundle);
                                          //***** COMBAT*****//
                                          choixChemin("2",R.string.chapitre2_2Kachikam,R.string.choix1_2_2Kachikam,R.string.choix2_2_2Kachikam,R.string.choix3_2_2Kachikam);
                                          choix1.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  gestionChapitre3();
                                              }
                                          });
                                          choix2.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  gestionChapitre3();
                                              }
                                          });
                                          choix3.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  cheminFinal(R.string.dommage,R.string.chapitre3_3Kachikam);
                                              }
                                          });
                                      }
                                  }
        );

        choix3.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          choixChemin("2",R.string.chapitre2_3Kachikam,R.string.choix1_2_3Kachikam,R.string.choix2_2_3Kachikam,R.string.choix3_2_3Kachikam);
                                          choix1.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  choixChemin("3",R.string.chapitre3_6Kachikam,R.string.choix1_3_6Kachikam,R.string.choix2_3_6Kachikam,R.string.choix3_3_6Kachikam);
                                                  choix1.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          cheminFinal(R.string.dommage,R.string.chapitrefin1Kachikam);
                                                      }
                                                  });
                                                  choix2.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          gestionChapitre4_1();
                                                      }
                                                  });
                                                  choix3.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          gestionChapitre4_2();
                                                      }
                                                  });
                                              }
                                          });
                                          choix2.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  choixChemin("3",R.string.chapitre3_5Kachikam,R.string.choix1_3_5Kachikam,R.string.choix2_3_5Kachikam,R.string.choix3_3_5Kachikam);
                                                  choix1.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          cheminFinal(R.string.dommage,R.string.chapitrefin1Kachikam);
                                                      }
                                                  });
                                                  choix2.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          gestionChapitre4_1();
                                                      }
                                                  });
                                                  choix3.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          gestionChapitre4_2();
                                                      }
                                                  });
                                              }
                                          });
                                          choix3.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  cheminFinal(R.string.dommage,R.string.chapitrefin1Kachikam);
                                              }
                                          });
                                      }
                                  }
        );
    }
}
