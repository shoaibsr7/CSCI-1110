package Solution;

import java.util.Scanner;

public class HumanMakeCoffee {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        CoffeeBeans[] coffeeSelection = new CoffeeBeans[4];
        CoffeeMaker machine = new CoffeeMaker(2500);
        machine.switchPower();

        for (int i = 0; i < coffeeSelection.length; i++) {
            String name = kb.nextLine();
            String blend = kb.nextLine();
            String roast = kb.nextLine();
            CoffeeBeans beans = new CoffeeBeans(name,blend,CoffeeBeans.Roast.valueOf(roast));
            coffeeSelection[i] = beans;
        }

        System.out.println("Welcome! Please select an option: ");
        int option = kb.nextInt();
        while (option != 0){
            if(option == 1){
                System.out.println("Here are your coffee options");
                for (int i = 0; i < coffeeSelection.length; i++) {
                    System.out.printf("(%d)\n%s\n",i+1, coffeeSelection[i].toString());
                    System.out.println("---------");
                }
                System.out.print("Make a selection: ");
                machine.loadCoffee(coffeeSelection[kb.nextInt() -1]);
            }
            if(option == 2){
                System.out.println(machine);
            }

            if(option == 3){
                System.out.print("How much water? ");
                machine.addWater(kb.nextInt());
            }
            if(option == 4){
                System.out.print("How many cups? ");
                if(!machine.brewCoffee(kb.nextInt())){
                    System.out.println("Hmm... something went wrong");
                }
                else {
                    System.out.println("Brewing coffee...");
                }

            }
            option = kb.nextInt();
        }



    }
}
