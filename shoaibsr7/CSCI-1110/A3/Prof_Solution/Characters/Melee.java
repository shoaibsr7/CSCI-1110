package Characters;

import Attacks.Attack;


import java.awt.*;

public abstract class Melee extends RPGCharacter {

    private int maxEnergy;
    private int currentEnergy;


    protected Melee(String name, int strength, int maxHP, Point position, int maxEnergy) {

        super(name, 1, strength, maxHP, position);
        this.maxEnergy = maxEnergy;
        currentEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    @Override
    public int attack(RPGCharacter target, int attackIndex) {
        if(attackIndex >= attackList.size()){
            return -1;
        }

        Attack attack = attackList.get(attackIndex);

        if(this.getPosition().distance(target.getPosition()) >
                attack.getRange()){
            return -2;
        }

        if(currentEnergy < attack.getCost()){
            return -3;
        }

        currentEnergy -= attack.getCost();
        attack.interactWithTarget(target,strength);

        return target.getCurrentHP();
    }

    @Override
    public String toString() {
        String result= super.toString();
        result += String.format("\nEnergy %d/%d", currentEnergy,maxEnergy);
        return result;
    }
}
