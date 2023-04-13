package Solution;

/**
 * Represents a coffee grinder which can grind coffee beans
 * @author Juliano Franz
 */
public class CoffeeGrinder {

    /**
     * Grinds coffee beans if they are whole bean
     * @param coffeeBeans the coffee beans we want to grind
     * @return true if the coffee is now ground. false if the coffee was already ground.
     */
    public boolean grindCoffee(CoffeeBeans coffeeBeans) {
        if(coffeeBeans.isGround()) {
            return false;
        }
        coffeeBeans.grind();
        return true;
    }
}
