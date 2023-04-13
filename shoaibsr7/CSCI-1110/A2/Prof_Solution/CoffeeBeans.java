package Solution;

/**
 * Class used to represent coffee beans in the make coffee assignment.
 * @author Juliano Franz
 */
public class CoffeeBeans {
    /**
     * Types of coffee beans roasts
     */
    public enum Roast {LIGHT, MEDIUM, MEDIUM_DARK, DARK}

    private boolean isGround;
    private Roast roast;
    private String blendName;
    private String brandName;

    /**
     * Creates a new coffee bean object with a defined brand and blend names plus roast and ground state
     * @param brandName The name of the brand of the coffee bean
     * @param blendName The name of the blend of the coffee bean
     * @param roast the bean's roast type: see Roast
     * @param isGround true if the coffee bean is ground, false if whole bean
     */
    public CoffeeBeans(String brandName, String blendName, Roast roast, boolean isGround){
        this.brandName = brandName;
        this.blendName = blendName;
        this.roast = roast;
        this.isGround = isGround;
    }

    /**
     * Creates a new coffee bean object with a defined brand and blend names plus roast.
     * Coffee bean is set to whole ban
     * @param brandName The name of the brand of the coffee bean
     * @param blendName The name of the blend of the coffee bean
     * @param roast the bean's roast type: see Roast
     */
    public CoffeeBeans(String brandName, String blendName, Roast roast){
        this(brandName,blendName,roast, false);
    }

    /**
     * Creates a new coffee bean object with a defined brand and blend names.
     * Coffee bean is set to whole bean and MEDIUM roast
     * @param brandName The name of the brand of the coffee bean
     * @param blendName The name of the blend of the coffee bean
     */
    public CoffeeBeans(String brandName, String blendName){
        this(brandName,blendName,Roast.MEDIUM,false);
    }

    /**
     * Getter for isGround property
     * @return true if the bean is ground, false otherwise
     */
    public boolean isGround() {
        return isGround;
    }

    /**
     * Getter for the roast
     * @return the roast type of the coffee
     */
    public Roast getRoast() {
        return roast;
    }

    /**
     * Getter for the brand name property
     * @return
     */
    public String getBrandName() {
        return brandName;
    }

    public String getBlendName(){
        return blendName;
    }

    /**
     * Changes the coffee bean from whole bean to ground
     * @return true if the coffee is now ground. False if the coffee was already ground
     */
    public boolean grind(){
        if(isGround){
            return false;
        }
        isGround = true;
        return true;
    }

    @Override
    public String toString() {
        String result = String.format("Brand: %s\nBlend: %s\nRoast type: %s",
                brandName,blendName,roast);
        if(isGround){
            result += "\nground";
        }
        else {
            result += "\nwhole bean";
        }
        return  result;
    }
}
