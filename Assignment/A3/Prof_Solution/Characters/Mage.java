package Characters;

import Attacks.DamageSpell;
import Attacks.MeleeAttack;
import Attacks.Spell;

import java.awt.*;
import java.util.ArrayList;

public class Mage extends Caster{

    public Mage(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name,intellect,maxHP,position,maxMana);

        //Base Characters.Mage Spells
        MeleeAttack staff = new MeleeAttack(0,"Staff",3,3);
        Spell fireBall = new DamageSpell(20,"Fire Ball", 10, 20);
        Spell frostBall = new DamageSpell(15,"Frost Ball", 7, 15);
        Spell lightning = new DamageSpell(30,"Lightning", 15, 20);

        attackList.add(staff);
        attackList.add(fireBall);
        attackList.add(frostBall);
        attackList.add(lightning);


    }
}
