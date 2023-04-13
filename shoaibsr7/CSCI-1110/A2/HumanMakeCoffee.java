/**
 * CSCI 1110 - Assignment 2
 *
 * This class makes some brew with the help of CoffeeBeans, CoffeeGrinder, CoffeeMaker classes.
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
import java.util.Scanner;

public class HumanMakeCoffee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /**
         * Creating coffee maker object with 2500ml capacity.
         */
        CoffeeMaker coffeeMaker = new CoffeeMaker(2500);

        /**
         * Creating coffee bean array to store 4 coffee types.
         * CITATION:
         * www.geeksforgeeks.org,
         * [Online] URL: https://www.geeksforgeeks.org/how-to-create-array-of-objects-in-java/
         * Date accessed: 25 Feb 2021
         */
        CoffeeBeans[] arrayOfCoffeeBeans = new CoffeeBeans[4];

        /**
         * Reading input from the user for CoffeeBeans array
         */
        for (int i = 0; i < 4; i++) {
            String brandName = in.nextLine();
            String blendName = in.nextLine();
            String roastType = in.nextLine();
            CoffeeBeans.Roast roast = CoffeeBeans.Roast.valueOf(roastType);
            arrayOfCoffeeBeans[i] = new CoffeeBeans(brandName, blendName, roast);
        }

        System.out.println("Welcome! Please select an option: ");
        int option = in.nextInt();

        while(option != 0){
            /**
             * Selection 1
             * Printing the output
             */
            if(option == 1){
                System.out.println("Here are your coffee options");
                int j = 1;
                for (int i = 0; i < 4; i++) {
                    System.out.println("("+j+")");
                    System.out.println(arrayOfCoffeeBeans[i].toString());
                    System.out.println("---------");
                    j++;
                }
                /**
                 * Turns on the CoffeeMaker machine and ask the user to enter which coffee type to load into the
                 * CoffeeMaker
                 */
                System.out.print("Make a selection: ");
                int loadCoffeeOption = in.nextInt();
                if(!coffeeMaker.isOn()){
                    coffeeMaker.switchPower();
                }
                coffeeMaker.loadCoffee(arrayOfCoffeeBeans[loadCoffeeOption-1]);
            }

            /**
             * Asking for selection from the user
             */
            option = in.nextInt();

            /**
             * Selection 2
             * Printing the CoffeeMaker toString()
             */
            if(option == 2){
                System.out.println(coffeeMaker.toString());
            }

            /**
             * Selection 3
             * Asks the user for how much water to add
             */
            if(option == 3){
                System.out.print("How much water? ");
                coffeeMaker.addWater(in.nextInt());
            }

            /**
             * Selection 4
             * Asks the user for the number of cups, if there is enough water for the requested amount of coffee then
             * brews the coffee
             */
            if(option == 4){
                System.out.print("How many cups? ");
                if(coffeeMaker.brewCoffee(in.nextInt())){
                    System.out.println("Brewing coffee...");
                }
                else{
                    System.out.print("Hmm... something went wrong");
                }
            }
        }
    }
}
