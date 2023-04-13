import java.util.Scanner;

public class P3 {

    public static int rowTotal(int[][] data, int row){
        if(row < 0 || row >= data.length){
            return -1;
        }

        int total = 0;
        for (int i = 0; i < data[0].length; i++) {
            total += data[row][i];
        }

        return total;
    }



    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int[][] my2DArray = new int[kb.nextInt()][kb.nextInt()];
        for (int i = 0; i < my2DArray.length; i++) {
            for (int j = 0; j < my2DArray[i].length; j++) {
                my2DArray[i][j] = kb.nextInt();
            }
        }

        System.out.printf("Total of row %d is %d\n", kb.nextInt(), rowTotal(my2DArray,kb.nextInt()));
    }

}
