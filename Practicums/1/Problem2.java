import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int amount = kb.nextInt();
        double sum = 0;

        for (int i = 0; i < amount; i++) {
            sum+= kb.nextDouble();
        }
        System.out.println(sum/amount);
    }
}
