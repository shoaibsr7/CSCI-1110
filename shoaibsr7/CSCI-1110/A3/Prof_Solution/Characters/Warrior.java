package Characters;

import Attacks.MeleeAttack;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Warrior extends Melee {
    public Warrior(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name,strength,maxHP,position, maxEnergy);

        //Base Warrior Attacks
        MeleeAttack punch = new MeleeAttack(0,"Punch",5,3);
        MeleeAttack slam = new MeleeAttack(3,"Slam",5,3);
        MeleeAttack charge = new MeleeAttack(20,"Charge", 30, 15);
        attackList.add(punch);
        attackList.add(slam);
        attackList.add(charge);

    }
}
