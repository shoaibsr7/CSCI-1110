package Characters;

import Attacks.*;

import java.awt.*;
import java.util.ArrayList;

public class Priest extends Caster {
    public Priest(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name,intellect,maxHP,position,maxMana);

        //Base Characters.Priest Spells
        MeleeAttack staff = new MeleeAttack(0,"Wand",3,3);
        DamageSpell smite = new DamageSpell(10,"Smite", 10, 7);
        HealingSpell flashHeal = new HealingSpell(20,"Flash Heal",15, 15);
        Resurrection resurrection = new Resurrection();

        attackList.add(staff);
        attackList.add(smite);
        attackList.add(flashHeal);
        attackList.add(resurrection);


    }
}
