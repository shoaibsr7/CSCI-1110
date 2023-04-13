import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int number = kb.nextInt();
        while(number >=0){
            System.out.println("The square root of " + number + " is " + Math.sqrt(number));
            number = kb.nextInt();
        }

        System.out.println("Bye!");

    }
}
