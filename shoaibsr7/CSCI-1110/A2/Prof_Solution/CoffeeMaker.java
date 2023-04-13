package Solution;

/**
 * Represent a coffee maker machine. The machine has a built in coffee grinder.
 * @author Juliano Franz
 */

public class CoffeeMaker {
    private double waterLevel;
    private boolean isOn;
    private CoffeeBeans loadedCoffee;
    private final double tankCapacity;
    private CoffeeGrinder grinder;

    /**
     * Creates a new Coffee Maker object with loaded coffee and a set water tank capacity.
     * @param coffee the coffee bean that we want to have the machine loaded with
     * @param tankCapacity the total water tank capacity in ml
     */
    public CoffeeMaker(CoffeeBeans coffee, double tankCapacity){
        this.waterLevel = 0;
        this.isOn = false;
        this.tankCapacity = tankCapacity;
        loadedCoffee = coffee;
        grinder = new CoffeeGrinder();
    }

    /**
     * Creates a coffee maker with a set tank capacity and no coffee loaded into it.
     * @param tankCapacity the total capacity of the water tank in ml
     */
    public CoffeeMaker(double tankCapacity){
        this(null, tankCapacity);
    }

    /**
     * Water level getter
     * @return the current amount of watter in the tank in ml
     */
    public double getWaterLevel() {
        return waterLevel;
    }

    /**
     * Switches the coffee maker on and off
     */
    public void switchPower(){
        isOn = !isOn;
    }

    /**
     * Getter for the machine power state
     * @return returns true if machine is on; false if it is off
     */
    public boolean isOn(){
        return isOn;
    }

    /**
     * Checks if the machine is loaded if coffee or not.
     * @return true if hte machine has coffee, false if it is empty
     */
    public boolean hasCoffee(){
        return loadedCoffee != null;
    }

    /**
     * Loads coffee into the machine
     * @param coffee the coffee we want to load
     * @return false if the parameter was null; true otherwise
     */
    public boolean loadCoffee(CoffeeBeans coffee){
        if(coffee == null){
            return false;
        }
        this.loadedCoffee = coffee;
        return true;

    }

    /**
     * Cleans the machine by removing any loaded coffee and emptying the water tank
     */
    public void clean(){
        this.loadedCoffee = null;
        waterLevel = 0;
    }

    /**
     * Adds water to the machine's tank. It will not overflow the tank.
     * @param waterQuantity the amount of water, in ml, to add
     */
    public void addWater(double waterQuantity){
        waterLevel += waterQuantity;
        if(waterLevel > tankCapacity){
            waterLevel = tankCapacity;
        }
    }

    /**
     * Brews coffee if the machine is on, has enough watter and coffee beans.
     * If the coffee beans were not ground, the machine will ground them automatically.
     * @param cups the amount of cups we want to brew
     * @return false if there wasn't enough water, no coffee or the machine was off; true otherwise
     */
    public boolean brewCoffee(int cups){
        double watterNeeded = cupsToMl(cups);
        //We need pressure and watter to make coffee.
        //Of course the machine needs to be on.
        if(!isOn || waterLevel < watterNeeded || loadedCoffee == null){
            return false;
        }

        //Coffee needs to be ground too.
        //The machine will automatically grind it
        if(!loadedCoffee.isGround()){
            grinder.grindCoffee(loadedCoffee);
        }

        //Should I make water boiling a thing too? Meh...
        waterLevel -= watterNeeded;
        return true;
    }

    @Override
    public String toString() {
        if(hasCoffee()){
            return String.format("isOn: %b\nwater left: %.2f\nloaded coffee: \n%s.",
                    isOn,waterLevel, loadedCoffee.toString());
        }
        return String.format("isOn: %b\nwater left: %.2f\nno coffee loaded.",
                isOn,waterLevel);

    }

    private double cupsToMl(int cups){
        return cups * 236.59;
    }



}
