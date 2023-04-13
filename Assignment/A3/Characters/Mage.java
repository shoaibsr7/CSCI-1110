/**
 * CSCI 1110 - Assignment 3
 *
 *  Concrete character of Casters
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
package Characters;

import Attacks.*;

import java.awt.Point;

public class Mage extends Caster {

    /**
     * Creates a new Caster object given the name, intellect, maxHP, position, maxMana and
     * creates a list of attacks and add them to attackList
     * @param name  the name of the character
     * @param intellect the intellect of the character
     * @param maxHP max HP of the character
     * @param position the position of the character
     * @param maxMana the maxMana the character will have
     */
    public Mage(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);

        MeleeAttack ds1  = new MeleeAttack(0,"Staff",3,3);
        DamageSpell ds2  = new DamageSpell(20,"Fire Ball",10,20);
        DamageSpell ds3  = new DamageSpell(15,"Frost Ball",7,15);
        DamageSpell ds4  = new DamageSpell(30,"Lightning",15,20);
        attackList.add(ds1);
        attackList.add(ds2);
        attackList.add(ds3);
        attackList.add(ds4);
    }
}