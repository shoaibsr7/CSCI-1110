package Characters;

import Attacks.Attack;
import Attacks.HealingSpell;
import Attacks.Spell;

import java.awt.*;


public abstract class Caster extends RPGCharacter {
    private int maxMana;
    private int currentMana;

    protected Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, 1, maxHP, position);

        this.maxMana = maxMana;
        currentMana = maxMana;
    }

    public int getCurrentMana(){
        return currentMana;
    }

    @Override
    public int attack(RPGCharacter target, int attackIndex) {
        if(attackIndex >= attackList.size()){
            return -1;
        }

        Attack attack = attackList.get(attackIndex);

        double distance = this.getPosition().distance(target.getPosition());

        if(this.getPosition().distance(target.getPosition()) >
                attack.getRange()){
            return -2;
        }

        if(currentMana < attack.getCost()){
            return -3;
        }

        currentMana -= attack.getCost();
        if(attack instanceof HealingSpell){
            attack.interactWithTarget(this,intellect);
        }
        else if(attack instanceof Spell){
            attack.interactWithTarget(target,intellect);
        }
        else {
            attack.interactWithTarget(target,0);
        }

         return target.getCurrentHP();
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += String.format("\nMana: %d/%d",currentMana,maxMana);
        return result;
    }
}
