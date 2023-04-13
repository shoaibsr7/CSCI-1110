import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        String separator = kb.next();
        String[] names = new String[num];
        for (int i = 0; i < num; i++) {
            names[i] = kb.next();
        }

        reversePrint(names,separator);

    }

    public static void reversePrint(String[] names, String separator){
        for (int i = names.length-1; i >= 0 ; i--) {
            if(i != names.length-1){
                System.out.print(separator);
            }

            System.out.print(names[i]);
        }
    }
}
