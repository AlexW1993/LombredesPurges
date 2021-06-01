package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

public class Combats {

    /**
     * Declaration des Attributs
     */
    private String enemy;
    private int force;
    private int combatskill;
    private int endurance;
    private boolean terminé = false;

    /**
     * Accesseurs de l'ennemi
     *
     * @return (String) l'ennemi
     */
    public String getEnemy() {
        return enemy;
    }

    /**
     * Accesseurs de la force de l'ennemi
     *
     * @return (int) la force de l'ennemi
     */
    public int getForce() {
        return force;
    }

    /**
     * Mutateur de la force de l'ennemi
     *
     * @param force, la force de l'ennemi
     */
    public void setForce(int force) {
        this.force = force;
    }

    public int getCombatskill() {
        return combatskill;
    }

    /**
     * Accesseurs de l'endurance' de l'ennemi
     *
     * @return (int) l'endurance' de l'ennemi
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Mutateur de l'endurance de l'ennemi
     *
     * @param endurance, l'endurance
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    /**
     * Méthode qui permet de savoir si le combat en terminé
     */
    public boolean isTerminé() {
        return terminé;
    }

    /**
     * Méthode qui permet de changer l'état du combat
     */
    public void setTerminé(boolean terminé) {
        this.terminé = terminé;
    }
}
