/**
 * CSCI 1110 - Assignment 2
 *
 * This class represents the concept of coffee grinder
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
public class CoffeeGrinder {
    /**
     * Grinds the coffee bean received as a parameter
     * @param coffeeBeans bean type whether ground or whole bean
     * @return true after grinding whole beans; if the beans are already ground return false.
     */
    public boolean grindCoffee(CoffeeBeans coffeeBeans){
        if(!coffeeBeans.isGround()){
            coffeeBeans.grind();
            return true;
        }
        else{
            return false;
        }
    }
}
