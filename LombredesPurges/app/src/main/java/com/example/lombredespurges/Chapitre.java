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

public class Chapitre extends Fragment {

    ImageView raceChap;
    TextView texteChapitre;
    TextView texteTitre;
    Button choix1;
    Button choix2;
    Button choix3;
    Button pageTitre;
    NavController navController;

    public Chapitre() {
        // Required empty public constructor
    }

    public static Chapitre newInstance(String param1, String param2) {
        Chapitre fragment = new Chapitre();
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

    public void cheminFinal(String _texteFin, int texte){
        String nom = getArguments().getString("nom");
        texteTitre.setText(_texteFin + nom);
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

    public void gestionChapitre4_1() {
        choixChemin("Chapitre 4",R.string.chapitre4_1Dino,R.string.choix1_4_1,R.string.choix2_4_1,R.string.choix3_4_1);
        choix1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal("Dommage ", R.string.chapitrefin4Dino);
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal("Dommage ", R.string.chapitrefin2Dino);
            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal("Dommage ", R.string.chapitrefin3Dino);
            }
        });
    }

    public void gestionChapitre4_2(){
        choixChemin("Chapitre 4",R.string.chapitre4_2Dino,R.string.choix1_4_2,R.string.choix2_4_2,R.string.choix3_4_2);
        choix1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal("Bravo ",R.string.chapitrefin5Dino);
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal("Dommage ",R.string.chapitrefin6Dino);
            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cheminFinal("Dommage ",R.string.chapitrefin7Dino);
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
        return inflater.inflate(R.layout.chapitre_histoire, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        raceChap = view.findViewById(R.id.raceChap);
        texteTitre = view.findViewById(R.id.texteTitre);
        texteChapitre = view.findViewById(R.id.texteChapitre);
        choix1 = view.findViewById(R.id.buttonChoix1);
        choix2 = view.findViewById(R.id.buttonChoix2);
        choix3 = view.findViewById(R.id.buttonChoix3);
        pageTitre = view.findViewById(R.id.buttonMenu);
        navController = Navigation.findNavController(view);
        changerImage();
        texteTitre.setText("Chapitre 1");
        texteChapitre.setText(R.string.chapitre1Dino);
        choix1.setText(R.string.choix1_1);
        choix2.setText(R.string.choix2_1);
        choix3.setText(R.string.choix3_1);
        choix1.setVisibility(View.VISIBLE);
        choix2.setVisibility(View.VISIBLE);
        choix3.setVisibility(View.VISIBLE);
        pageTitre.setVisibility(View.GONE);

        choix1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choixChemin("Chapitre 2",R.string.chapitre2_1Dino,R.string.choix1_2_1,R.string.choix2_2_1,R.string.choix3_2_1);
                        choix1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                choixChemin("Chapitre 3",R.string.chapitre3_1Dino,R.string.choix1_3_1,R.string.choix2_3_1,R.string.choix3_3_1);
                                choix1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        cheminFinal("Dommage ",R.string.chapitrefin1Dino);
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
                                        gestionChapitre4_2();                                    }
                                });
                            }
                        });
                        choix2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                cheminFinal("Dommage ",R.string.chapitre3_2Dino);
                            }
                        });
                        choix3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                cheminFinal("Dommage ",R.string.chapitre3_3Dino);
                            }
                        });

                    }
                }
        );

        choix2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choixChemin("Chapitre 2",R.string.chapitre2_2Dino,R.string.choix1_2_2,R.string.choix2_2_2,R.string.choix3_2_2);
                        choix1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                choixChemin("Chapitre 3",R.string.chapitre3_1Dino,R.string.choix1_3_1,R.string.choix2_3_1,R.string.choix3_3_1);
                                choix1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        cheminFinal("Dommage ",R.string.chapitrefin1Dino);
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
                                choixChemin("Chapitre 3",R.string.chapitre3_2Dino,R.string.choix1_3_2,R.string.choix2_3_2,R.string.choix3_3_2);
                                choix1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        cheminFinal("Dommage ",R.string.chapitrefin1Dino);
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
                                cheminFinal("Dommage ",R.string.chapitre3_3Dino);
                            }
                        });
                    }
                }
        );

        choix3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choixChemin("Chapitre 2",R.string.chapitre2_3Dino,R.string.choix1_2_3,R.string.choix2_2_3,R.string.choix3_2_3);
                        choix1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                choixChemin("Chapitre 3",R.string.chapitre3_6Dino,R.string.choix1_3_6,R.string.choix2_3_6,R.string.choix3_3_6);
                                choix1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        cheminFinal("Dommage ",R.string.chapitrefin1Dino);
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
                                choixChemin("Chapitre 3",R.string.chapitre3_5Dino,R.string.choix1_3_5,R.string.choix2_3_5,R.string.choix3_3_5);
                                choix1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        cheminFinal("Dommage ",R.string.chapitrefin1Dino);
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
                                cheminFinal("Dommage ",R.string.chapitrefin1Dino);
                            }
                        });
                    }
                }
        );
    }


}