/**
 * CSCI 1110 - Assignment 2
 *
 * This class represents the concept of coffee maker
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
public class CoffeeMaker {
    private double waterLevel;
    private boolean isOn;
    private CoffeeBeans loadedCoffee;
    private double tankCapacity;
    private CoffeeGrinder grinder;

    /**
     * Create a new coffee maker
     * @param loadedCoffee loads the coffee
     * @param tankCapacity defines the size of water tank in ML
     */
    public CoffeeMaker(CoffeeBeans loadedCoffee, double tankCapacity) {
        isOn = false;
        waterLevel = 0.0;
        this.loadedCoffee = loadedCoffee;
        this.tankCapacity = tankCapacity;
        grinder = new CoffeeGrinder();
    }

    /**
     * Creates new coffee maker with tank size defined
     * @param tankCapacity defines the size of water tank in ML
     */
    public CoffeeMaker(double tankCapacity) {
        this.tankCapacity = tankCapacity;
        grinder = new CoffeeGrinder();
    }

    /**
     * Getter for the current water level
     * @return water level in the tank
     */
    public double getWaterLevel() {
        return waterLevel;
    }

    /**
     * turns on/off the coffee maker
     */
    public void switchPower(){
        if(!isOn){
            isOn = true;
        }
        else{
            isOn = false;
        }
    }

    /**
     * Checks if coffee maker is on/off
     * @return true is coffee maker is on and vice versa
     */
    public boolean isOn(){
        return isOn;
    }

    /**
     * Checks if the coffee maker has coffee loaded in it
     * @return true if coffee is loaded into the coffee maker; false otherwise
     */
    public boolean hasCoffee(){
        if(loadCoffee(loadedCoffee)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Loads coffee into the coffee maker
     * @param loadedCoffee loads the coffee
     * @return true after loading the coffee maker; false if parameter is null
     */
    public boolean loadCoffee(CoffeeBeans loadedCoffee){
        if(loadedCoffee == null){
            return false;
        }
        else{
            this.loadedCoffee = loadedCoffee;
            return true;
        }
    }

    /**
     * Removes the coffee and water from the coffee maker
     */
    public void clean(){
        waterLevel = 0.0;
        loadedCoffee = null;
    }

    /**
     * Adds water into the container
     * @param waterLevel the amount of water that will be added
     */
    public void addWater(double waterLevel){
        if(waterLevel < tankCapacity){
            this.waterLevel += waterLevel;
        }
        else{
            this.waterLevel = tankCapacity;
        }
    }

    /**
     * Brews the coffee in the coffee maker
     * @param cups number of cups of coffee to be made
     * @return true if coffee was brewed successfully; false if there isn't enough water for the requested amount of
     * coffee
     */
    public boolean brewCoffee(int cups){
        if(getWaterLevel() > cupsToML(cups) && loadedCoffee != null){
            grinder.grindCoffee(loadedCoffee);
            waterLevel -=  cupsToML(cups);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Converts the number of cups to ML
     * @param cups number of cups
     * @return total ML for all the cups
     */
    private double cupsToML(int cups){
        return (cups*236.59);
    }

    /**
     * Creates a string representation of the object
     * @return a string representation of the object
     */
    public String toString(){
        String result = String.format("isOn: %b\nwater left: %.2f\n",isOn(),getWaterLevel());
        if(hasCoffee()){
            String loaded = "loaded coffee: \n";
            String yesCoffee = loadedCoffee.toString();
            return result+loaded+yesCoffee+".";
        }
        else{
            String noCoffee = "no coffee loaded.";
            return result+noCoffee;
        }

    }
}
