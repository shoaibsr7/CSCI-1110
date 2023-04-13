/**
 * CSCI 1110 - Assignment 3
 *
 *  Concrete character of Melee
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
package Characters;

import Attacks.*;

import java.awt.Point;

public class Warrior extends Melee {

    /**
     * Creates a new Melee object given the name, strength, maxHP, position, maxEnergy and
     * creates a list of attacks and add them to attackList
     * @param name the name of the character
     * @param strength the strength of the character
     * @param maxHP max HP of the character
     * @param position the position of the character
     * @param maxEnergy the maxEnergy the character will have
     */
    public Warrior(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, strength, maxHP, position, maxEnergy);

        MeleeAttack ds1 = new MeleeAttack(0,"Punch",5,3);
        MeleeAttack ds2 = new MeleeAttack(3,"Slam",5,3);
        MeleeAttack ds3 = new MeleeAttack(20,"Charge",30,15);
        attackList.add(ds1);
        attackList.add(ds2);
        attackList.add(ds3);
    }
}