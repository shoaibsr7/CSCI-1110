/**
 * CSCI 1110 - Assignment 3
 *
 * Base character class. It creates the foundation for all characters such as mage priest warrior.
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */

package Characters;
import Attacks.*;

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

    /**
     * Creates a new character object given the name, intellect, strength, maxHP, position
     * @param name the name of the character
     * @param intellect the intellect of the character
     * @param strength strength of the character
     * @param maxHP max HP of the character
     * @param position the position of the character
     */
    public RPGCharacter(String name, int intellect, int strength, int maxHP, Point position) {
        this.name = name;
        this.intellect = intellect;
        this.strength = strength;
        this.maxHP = maxHP;
        this.position = position;
        this.currentHP = maxHP;
        attackList = new ArrayList<>();
    }

    /**
     * No need for Java Docs
     */
    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * No need for Java Docs
     */
    public Point getPosition() {
        return position;
    }

    /**
     * No need for Java Docs
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * No need for Java Docs
     */
    public String getName() {
        return name;
    }

    /**
     * Moves the character from one place to another
     * @param x the x-coordinate of the character
     * @param y the y-coordinate of the character
     */
    public void move(int x, int y){
        position.translate(x,y);
    }

    /**
     * Causes damage on the character by subtracting the explicit parameter (damage) from currentHP
     * @param damage amount of damage to cause
     * @return false if the character is dead; true if damage was successful
     */
    public boolean takeDamage(int damage){
        int health = currentHP - damage;
        if(health <= 0){
            currentHP = 0;
            return false;
        }
        else{
            currentHP -= damage;
            return true;
        }
    }

    /**
     * Heals the character by adding the explicit parameter (health) to currentHP
     * @param health amount of health to heal
     * @return true if character health reached 100; false otherwise
     */
    public boolean heal(int health){
        int newHealth = health + currentHP;
        if(newHealth >= maxHP){
            currentHP = maxHP;
            return true;
        }
        else {
            currentHP += health;
            return false;
        }
    }

    /**
     * method used to attack the target or heal the character
     * @param target the RPGCharacter target of the attack
     * @param attackModifier the attack to choose from the attackList of the character
     * @return target currentHP
     */
    public abstract int attack(RPGCharacter target, int attackModifier);

    /**
     * Prints the attack from the list of attacks of the character
     * @return attack list of the character
     */
    public String getAttacks(){
        String result = "";
        for (int i = 0; i < attackList.size(); i++) {
            result += (i + " - " + attackList.get(i).toString() + "\n");
        }
        return result;
    }

    /**
     * No need for Java Docs
     */
    public String toString(){
        return String.format("%s (%s) - %d/%d", this.getName(), this.getClass().getSimpleName(),
                this.getCurrentHP(), this.getMaxHP());
    }
}