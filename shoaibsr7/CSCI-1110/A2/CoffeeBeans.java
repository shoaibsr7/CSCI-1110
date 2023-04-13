/**
 * CSCI 1110 - Assignment 2
 *
 * This class represents the concept of coffee beans with ground type, blend name,
 * brand name, Roast type
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
public class CoffeeBeans {
//    boolean true for ground, false for whole bean
    private boolean isGround;
    public enum Roast{
        LIGHT,
        MEDIUM,
        MEDIUM_DARK,
        DARK
    }
    private Roast roast;
    private String blendName;
    private String brandName;

    /**
     * Creates a new coffee
     * @param brandNameFromMain Brand name from the user
     * @param blendNameFromMain Blend name from the user
     * @param type roast type from Roast
     * @param isGroundFromMain bean type ground or whole; true for ground and false for whole
     */
    public CoffeeBeans(String brandNameFromMain, String blendNameFromMain, Roast type, boolean isGroundFromMain){
        this.brandName = brandNameFromMain;
        this.blendName = blendNameFromMain;
        roast = type;
        this.isGround = isGroundFromMain;
    }

    /**
     * Creates a new coffee with bean type set to false(whole)
     * @param brandNameFromMain Brand name from the user
     * @param blendNameFromMain Blend name from the user
     * @param type roast type from Roast
     */
    public CoffeeBeans(String brandNameFromMain, String blendNameFromMain, Roast type){
        this(brandNameFromMain, blendNameFromMain, type, false);
    }

    /**
     * Creates a new coffee with roast type set to MEDIUM bean type set to false(whole)
     * @param brandNameFromMain Brand name from the user
     * @param blendNameFromMain Blend name from the user
     */
    public CoffeeBeans(String brandNameFromMain, String blendNameFromMain){
        this(brandNameFromMain,blendNameFromMain,Roast.MEDIUM,false);
    }

    /**
     * Checks whether bean is ground or whole
     * @return true for ground beans and false for whole bean
     */
    public boolean isGround(){
        return isGround;
    }

    /**
     * Getter for the current roast type
     * @return the current roast type
     */
    public Roast getRoast(){
        return roast;
    }

    /**
     * Getter for the brand name
     * @return the brand name
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * Getter for the blend name
     * @return the blend name
     */
    public String getBlendName(){
        return blendName;
    }

    /**
     * if ground is false change ground to true and if ground is true return false
     * @return true if coffee switched from whole bean to ground.
     * Returns false if the coffee was already ground.
     */
    public boolean grind(){
        if(!isGround()){
            isGround = true;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Creates a string representation of the object
     * @return a string representation of the object
     */
    public String toString(){
        String result = String.format("Brand: %s\nBlend: %s\nRoast type: ",brandName,blendName);
        Roast roastType = getRoast();
        String groundType = "";
        if(!isGround()){
            groundType = "\nwhole bean";
        }
        else{
            groundType = "\nground";
        }
        return result+roastType+groundType;
    }
}
