package Characters;

import Attacks.Attack;

import java.awt.Point;
import java.util.ArrayList;

public abstract class RPGCharacter {
    private String name;
    private int maxHP;
    private Point position;

    protected int currentHP;
    protected int intellect;
    protected int strength;
    protected ArrayList<Attack> attackList;


    protected RPGCharacter(String name, int intellect, int strength, int maxHP, Point position) {
        this.name = name;
        this.intellect = intellect;
        this.strength = strength;
        this.maxHP = maxHP;
        this.currentHP = this.maxHP;
        this.position = position;
        attackList = new ArrayList<>();
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public Point getPosition() {
        return position;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public String getName(){
        return name;
    }

    public void move(int xDirection, int yDirection) {
        position.translate(xDirection, yDirection);
    }

    public boolean takeDamage(int damage){
        this.currentHP -= damage;
        if(currentHP <= 0) {
            currentHP = 0;
            return false;
        }
        return true;
    }

    public boolean heal(int healPoints){
        currentHP += healPoints;
        if(currentHP > maxHP){
            currentHP = maxHP;
            return true;
        }
        return false;
    }

    public abstract int attack(RPGCharacter target, int attackIndex);

    public String getAttacks(){
        String result = "";
        for (int i = 0; i < attackList.size(); i++) {
            result += i + " - " + attackList.get(i) + "\n";
        }
        return result;

    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d/%d",
                name, this.getClass().getSimpleName(), currentHP,maxHP);
    }
}
