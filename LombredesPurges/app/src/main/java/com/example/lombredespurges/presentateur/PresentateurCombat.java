package com.example.lombredespurges.presentateur;

import com.example.lombredespurges.Combat;
import com.example.lombredespurges.modèle.Ennemie;
import com.example.lombredespurges.modèle.Personnage;

import java.util.Random;

public class PresentateurCombat {

    /**
     * Declaration des Attributs
     */
    private Combat _combat;
    private Personnage _personnage;
    private Ennemie _ennemie;

    /**
     * Constructeur du presentateur du combat.
     *
     * @param vueCombat, la vue Combat.
     */
    public PresentateurCombat(Combat vueCombat) {

        this._combat = vueCombat;
        creationEnnemie();
    }

    /**
     * La méthode permet de creer une ennemie avec tous ses attibuts.
     */
    public void creationEnnemie(){
        _ennemie = new Ennemie("Purge",5,5,5,5);
        /*
        int num,force,endurence,agilité,intelligence;
        num = new Random().nextInt((6 - 1) + 1) + 1;
        force = 10 + num;
        num = new Random().nextInt((10 - 1) + 1) + 1;
        endurence = 20 + (2 * num);
        num = new Random().nextInt((6 - 1) + 1) + 1;
        agilité = 10 + num;
        num = new Random().nextInt((6 - 1) + 1) + 1;
        intelligence = 5 + num;
        _ennemie = new Ennemie("Purge",force,endurence,agilité,intelligence);*/
    }

    /**
     * La méthode permet de adquirir une personnage avec son nom et ses attibuts.
     *
     *  @param personnage, le personnage de l'histoire.
     */
    public void personnage(Personnage personnage){
        this._personnage = personnage;
    }

    /**
     * La méthode permet de chercher et retourner le nom du ennemie.
     *
     * @return le nom du ennemie.
     */
    public String nomEnnemie(){
        return this._ennemie.get_nom();
    }

    /**
     * La méthode permet de chercher et retourner la force d'un ennemie.
     *
     * @return (int) la force total du ennemie.
     */
    public int forceEnnemie(){
        return this._ennemie.get_force();
    }

    /**
     * La méthode permet de chercher et retourner l'endurance d'un ennemie.
     *
     * @return (int) l'endurance total du ennemie.
     */
    public int endurenceEnnemie(){
        return this._ennemie.get_endurance();
    }

    /**
     * La méthode permet de chercher et retourner la coeficience d'attaque d'un ennemie.
     *
     * @return (int) la coeficience d'attaque total du ennemie.
     */
    public int coefAttaqueEnnemie(){
        return this._ennemie.getCoefAttaque();
    }

    /**
     * La méthode permet de chercher et retourner la coeficience de défence d'un ennemie.
     *
     * @return (int) la coeficience de défence total du ennemie.
     */
    public int coefDefencéEnnemie(){
        return this._ennemie.getCoefDéfence();
    }

    /**
     * La méthode permet de chercher et retourner le dommages d'un ennemie.
     *
     * @return (int) la total du dommages.
     */
    public int dommagesEnnemie(){
        return this._ennemie.getDommages();
    }

    /**
     * La méthode permet de chercher et retourner le nom du personnage.
     *
     * @return le nom du personnage.
     */
    public String nomPersonnage(){
        return this._personnage.get_nom();
    }

    /**
     * La méthode permet de chercher et retourner la force du personnage.
     *
     * @return (int) la force total du personnage.
     */
    public int forcePersonnage(){
        return this._personnage.get_force();
    }

    /**
     * La méthode permet de chercher et retourner l'endurance du personnage.
     *
     * @return (int) l'endurance total du personnage.
     */
    public int endurencePersonnage(){
        return this._personnage.get_endurance();
    }

    /**
     * La méthode permet de chercher et retourner l'agilité du personnage.
     *
     * @return (int) l'agilité total du personnage.
     */
    public int agilitéPersonnage(){
        return this._personnage.get_agilité();
    }

    /**
     * La méthode permet de chercher et retourner la coeficience d'attaque du personnage.
     *
     * @return (int) la coeficience d'attaque total du personnage.
     */
    public int coefAttaquePersonnage(){
        return this._personnage.getCoefAttaque();
    }

    /**
     * La méthode permet de chercher et retourner la coeficience de défence du personnage.
     *
     * @return (int) la coeficience de défence total du personnage.
     */
    public int coefDefencéPersonnage(){
        return this._personnage.getCoefDéfence();
    }

    /**
     * La méthode permet de chercher et retourner le dommages du personnage.
     *
     * @return (int) la total du dommages.
     */
    public int dommagesPersonnage(){
        return this._personnage.getDommages();
    }

    /**
     * La méthode permet de comparer le coeficience d'attaquer du personnage avec
     * la coeficience d'attaque de l'ennemie.
     *
     * @return (boolean) (true) si le coeficience d'attaque du personnage est plus grand
     * ou égale, (false) si le coeficience d'attaque de l'ennemie est plus grand.
     */
    public boolean comparaisonCoefAttaque(){
        if(_personnage.getCoefAttaque() >= _ennemie.getCoefAttaque()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * La méthode permet de savoir si le personnage ou l'ennemi va attaquer. Si le dommage est très grand,
     * le personnage ou l'ennemie peut perdre la bataille.
     *
     * @param tourJoueur, (boolean) (true) si c'est le tour du personnage ou (false) si c'est
     *                    le tour de l'ennemie
     *
     * @return (int) (1 ou 2) (1) si l'endurence de l'ennmeie est plus petit ou égale à 0,
     *         (2) si l'endurence de l'ennmeie est plus grand à 0. (3 ou 4) (1) si l'endurence
     *         du personnage est plus petit ou égale à 0,
     *         (2) si l'endurence du personnage est plus grand à 0
     */
    public int tourDAttaquer(boolean tourJoueur){

        if (tourJoueur){
            _ennemie.calculerCoefDéfense(_personnage.getCoefAttaque());
            _ennemie.calculerEtRecevoirDommage(_personnage.get_force());
            if(_ennemie.get_endurance() <= 0){
                return 1;
            }else{
                return 2;
            }
        }else{
            _personnage.calculerCoefDéfense(_ennemie.getCoefAttaque());
            _personnage.calculerEtRecevoirDommage(_ennemie.get_force());
            if(_personnage.get_endurance() <= 0) {
                return 3;
            }else{
                return 4;
            }
        }
    }

    /**
     * La méthode permet de comparer de l'endurance du personnage ou de l'ennemi à 0.
     *
     * @return (int) (1) si l'endurance du personnage est plus petite à 0,
     *               (2) si l'endurance de l'ennemie est plus petite à 0,
     *               (3) si l'endurance du personnage et l'ennemie sont  plus grand à 0,
     */
    public int comparerEndurance(){
        if(_personnage.get_endurance() <= 0){
            return 1;
        }else if(_ennemie.get_endurance() <= 0){
            return 2;
        }else {
            return 0;
        }
    }

    /**
     * La méthode permet de calculer la coeficience d'attaque du personnage
     * et de l'ennemie.
     */
    public void calculerCoefAttaque(){
        _ennemie.calculerCoefAttaqueEnnemi();
        _personnage.calculerCoefAttaquePersonnage();
    }
}
