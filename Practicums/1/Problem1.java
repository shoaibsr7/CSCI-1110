import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int number = kb.nextInt();
        if (number % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
