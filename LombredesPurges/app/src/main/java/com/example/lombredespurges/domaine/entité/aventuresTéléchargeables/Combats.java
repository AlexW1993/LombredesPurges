package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

public class Combats {
    private String enemy;
    private int force;
    private int combatskill;
    private int endurance;
    private boolean terminé = false;

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getCombatskill() {
        return combatskill;
    }

    public void setCombatskill(int combatskill) {
        this.combatskill = combatskill;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public boolean isTerminé() {
        return terminé;
    }

    public void setTerminé(boolean terminé) {
        this.terminé = terminé;
    }
}
