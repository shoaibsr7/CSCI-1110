/**
 * CSCI 1110 - Assignment 3
 *
 *  Implementation of Melee, these types of characters deal damage using physical attacks.
 *  Most of these attacks will consume energy.
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
package Characters;

import Attacks.*;

import java.awt.Point;

public abstract class Melee extends RPGCharacter {
    private int maxEnergy;
    private int currentEnergy;

    /**
     * Creates a new Melee object given the name, intellect initialized as 1, strength, maxHP, position, maxEnergy
     * @param name the name of the character
     * @param strength the strength of the character
     * @param maxHP max HP of the character
     * @param position the position of the character
     * @param maxEnergy the maxEnergy the character will have
     */
    public Melee(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, 1, strength, maxHP, position);
        this.maxEnergy = maxEnergy;
        this.currentEnergy = maxEnergy;
    }

    /**
     * No need for Java Docs
     */
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * method used to attack the target
     * @param target the RPGCharacter target of the attack
     * @param attackModifier the attack to choose from the attackList of the character
     * @return -1 if index out of bound; -2 if target out of range; -3 if currentEnergy is less than the energy
     * required for the attack; target currentHP
     */
    public int attack(RPGCharacter target, int attackModifier) {
        if(attackModifier >= attackList.size() || attackModifier < 0){
            return -1;
        }
        if(this.getPosition().distance(target.getPosition()) > attackList.get(attackModifier).getRange()){
            return -2;
        }
        if(currentEnergy < attackList.get(attackModifier).getCost()){
            return -3;
        }
//        Deal damage on the target by passing the target and the characters strength
        attackList.get(attackModifier).interactWithTarget(target,this.strength);

//        if the attack was successfull subtract the currentEnergy with the energy required for the attack
        currentEnergy -= attackList.get(attackModifier).getCost();

        return target.getCurrentHP();
    }

    /**
     * No need for Java Docs
     */
    public String toString(){
        return super.toString() + String.format("\nEnergy %d/%d",currentEnergy,maxEnergy);
    }
}