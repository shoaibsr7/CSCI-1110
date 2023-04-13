/**
 * CSCI 1110 - Assignment 3
 *
 *  Implementation of Casters, characters who deal damage by casting spells primarily
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
package Characters;

import Attacks.*;

import java.awt.Point;

public abstract class Caster extends RPGCharacter{
    private int maxMana;
    private int currentMana;

    /**
     * Creates a new Caster object given the name, intellect, strength initialized as 1, maxHP, position, maxMana
     * @param name  the name of the character
     * @param intellect the intellect of the character
     * @param maxHP max HP of the character
     * @param position the position of the character
     * @param maxMana the maxMana the character will have
     */
    public Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, 1, maxHP, position);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    /**
     * No need for Java Docs
     */
    public int getCurrentMana(){
        return currentMana;
    }

    /**
     * method used to attack the target or heal the character
     * @param target the RPGCharacter target of the attack
     * @param attackModifier the attack to choose from the attackList of the character
     * @return -1 if index out of bound; -2 if target out of range; -3 if currentMana is less than the mana required
     * for the attack; target currentHP
     */
    public int attack(RPGCharacter target, int attackModifier){
        if(attackModifier >= attackList.size() || attackModifier < 0){
            return -1;
        }
        if(this.getPosition().distance(target.getPosition()) > attackList.get(attackModifier).getRange()){
            return -2;
        }
        if(currentMana < attackList.get(attackModifier).getCost()){
            return -3;
        }
        /*
         * Unreachable Code Error in Java, www.geeksforgeeks.org
         * https: //www.geeksforgeeks.org/unreachable-code-error-in-java/#:~:text=The%20Unreachable%20statements
         * %20refers%20to,an%20infinite%20loop%20before%20them
         * Author: AnshulVaidya
         * Date accessed: 13 March 2021
         */
//        if the attack we get from the attackList is an instanceof of healingSpell we heal the character itself and
//        pass the characters intellect
        if(attackList.get(attackModifier) instanceof HealingSpell){
            attackList.get(attackModifier).interactWithTarget(this,this.intellect);
        }
//        if the attack we get from the attackList is an instanceof of DamageSpell we attack the target and
//        pass the target and intellect
        else if(attackList.get(attackModifier) instanceof DamageSpell) {
            attackList.get(attackModifier).interactWithTarget(target,intellect);
        }
//        if the attack we get from the attackList is not an instanceof of healingSpell or DamageSpell we attack the
//        target and pass the target and 0
        else {
            attackList.get(attackModifier).interactWithTarget(target,0);
        }
//        if the attack was successfull subtract the currentMana with the mana required for the attack
        currentMana -= attackList.get(attackModifier).getCost();

        return target.getCurrentHP();
    }

    /**
     * No need for Java Docs
     */
    public String toString(){
        return super.toString() + String.format("Mana: %d/%d",currentMana,maxMana);
    }
}