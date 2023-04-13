package Game;

import Characters.*;
import java.awt.*;
import Characters.Caster;

public class Tester {
public static void main(String[] args){



    Caster aCaster = new Priest("Znarf", 10, 100, new Point(2, 0), 5);

    Melee attackTarget = new Warrior("Gulf", 20, 100, new Point(0, 0), 100);

//Caster should not a able to cast as pell without enough mana

if(aCaster.attack(attackTarget,1)!=-3)

    {

        System.out.println("Not enough mana for the attack, it should return -3");

    }

//But we should be able to use attacks with zero cost

    System.out.println(attackTarget.getCurrentHP());
    //System.out.println(aCaster.attack(attackTarget,0));
if(aCaster.attack(attackTarget,0)!=97)
    {
        System.out.println(attackTarget.getCurrentHP());


        System.out.println("Caster used physical attack with not cost\n" +
                "It should cause a damage of 3 + 0 as the modifier");
    }
}
}

