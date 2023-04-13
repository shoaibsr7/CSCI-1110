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

public class Priest extends Caster{

    /**
     * Creates a new Caster object given the name, intellect, maxHP, position, maxMana and
     * creates a list of attacks and add them to attackList
     * @param name  the name of the character
     * @param intellect the intellect of the character
     * @param maxHP max HP of the character
     * @param position the position of the character
     * @param maxMana the maxMana the character will have
     */
    public Priest(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);

        MeleeAttack ds1 = new MeleeAttack(0,"Wand",3,3);
        DamageSpell ds2 = new DamageSpell(10,"Smite",10,7);
        HealingSpell ds3 = new HealingSpell(20,"Flash Heal",15,15);
        Resurrection rs = new Resurrection();
        attackList.add(ds1);
        attackList.add(ds2);
        attackList.add(ds3);
        attackList.add(rs);
    }
}