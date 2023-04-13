/**
 * This program calculates the final marks of x student and converts them to their respective grades using a method
 * and calculates the class average and class median using getMedian method
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //initializing variables
        int numberOfStudents = in.nextInt();

        String idNumber [] = new String[numberOfStudents];

        int test [][] = new int[numberOfStudents][4];
        double test1DArray [] = new double [numberOfStudents];

        int assignment [][] = new int[numberOfStudents][5];
        double assignment1DArray [] = new double [numberOfStudents];

        int practicums [][] = new int[numberOfStudents][5];
        double practicums1DArray [] = new double [numberOfStudents];

        int PoDs [][] = new int[numberOfStudents][2];
        double PoDs1DArray [] = new double [numberOfStudents];

        double marksForTest = 0;
        double marksForAssignment = 0;
        double marksForPracticum = 0;
        double marksForPoD = 0;

        double finalMarks [] = new double[numberOfStudents];

        double testAverage = 0;
        double assignmentAverage = 0;
        double practicumAverage = 0;
        double PoDAverage = 0;

        //using a for loop to iterate through each row of the 2D array
        for (int i = 0; i < numberOfStudents; i++) {
            /**
             * using 1D array idNumber as a way of using them as the rows for 2D array something like this
             * b09863   1   2   3
             * b09220   3   2   1
             * and so on
             */
            idNumber[i] = in.next();

            /**
             * using a for loop to store data from the user into the array then adding each element in the same row and
             * storing the sum at index i last column something like this
             * b09863   1   2   3   6
             * b09220   3   2   1   6
             * and so on
             */
            for (int j = 0; j < 3; j++) {
                test[i][j] = in.nextInt();
                test[i][3] += test[i][j];
            }
            //storing the sum from the array to a double variable
            testAverage += test[i][3];


            /**
             * using a for loop to store data from the user into the array then adding each element in the same row and
             * storing the sum at index i last column something like this
             * b09863   1   2   3   6   12  24
             * b09220   3   2   1   6   12  24
             * and so on
             */
            for (int j = 0; j < 5; j++) {
                assignment[i][j] = in.nextInt();
            }
            //using Arrays.sort() to sort the array in ascending order
            Arrays.sort(assignment[i]);
            //since we drop the lowest grade which is now at index 0 we add the marks from index 1 to 4
            for (int j = 1; j < 5; j++) {
                //storing the sum from the array to a double variable
                assignmentAverage += assignment[i][j];
            }


            /**
             * using a for loop to store data from the user into the array then adding each element in the same row and
             * storing the sum at index i last column something like this
             * b09863   1   2   3   6   12
             * b09220   3   2   1   6   12
             * and so on
             */
            for (int j = 0; j < 4; j++) {
                practicums[i][j] = in.nextInt();
                practicums[i][4] += practicums[i][j];
            }
            //storing the sum from the array to a double variable
            practicumAverage += practicums[i][4];


            /**
             * using a for loop to store data from the user into the array then adding each element in the same row and
             * storing the sum at index i last column something like this
             * b09863   1   1
             * b09220   3   3
             * and so on
             */
            for (int j = 0; j < 1; j++) {
                PoDs [i][j] = in.nextInt();
                PoDs [i][1] += PoDs[i][j];
            }
            //storing the sum from the array to a double variable
            PoDAverage += PoDs[i][1];
        }

        for (int i = 0; i < numberOfStudents; i++) {
            marksForTest = 0;
            marksForAssignment = 0;
            marksForPracticum = 0;
            marksForPoD = 0;

            //using a for loop to store data from the user into the array then adding each element at index i and storing
            //the sum in marksForTest
            marksForTest += test[i][3];

            //since we drop the lowest grade which is now at index 0 we add the marks from index 1 to 4
            for (int j = 1; j < 5; j++) {
                marksForAssignment += assignment[i][j];
            }

            //using a for loop to store data from the user into the array then adding each element at index i and storing
            //the sum in marksForPracticum
            marksForPracticum += practicums[i][4];

            //storing the pod marks in PoDs
            marksForPoD += PoDs[i][1];

            //calculation of each assessment
            marksForTest = marksForTest/3*0.25;
            //divide by 4 because we drop the lowest score
            marksForAssignment = marksForAssignment/4*0.30;
            marksForPracticum = marksForPracticum/4*0.35;
            marksForPoD = marksForPoD*0.1;
            finalMarks[i] = marksForTest + marksForAssignment + marksForPracticum + marksForPoD;
            finalMarks[i] = Math.floor(finalMarks[i]);
            System.out.println(idNumber[i] + " " +scoreToLetterGrade(finalMarks,i));
        }


        //using a for loop to iterate through each row of the 2D array
        for (int i = 0; i < numberOfStudents; i++) {
            /**
             * storing the sum of each assessment stored in the last column of the 2D array into
             * their respective 1D array
             */

            test1DArray[i] = test[i][3];

            //since we are dropping the lowest grade we start from index 1 and not 0 since at index 0 we have the
            //lowest score
            for (int j = 1; j < 5; j++) {
                assignment1DArray[i] += assignment[i][j];
            }

            practicums1DArray[i] = practicums[i][4];

            PoDs1DArray[i] = PoDs[i][1];
        }

        /**
         * storing each element in a temp variable and dividing by 3 (since 3 tests) storing them into the 1DArray
         */
        for (int i = 0; i < numberOfStudents; i++) {
            double temp = test1DArray[i];
            test1DArray[i] = temp/3;
        }

        /**
         * storing each element in a temp variable and dividing by 4 (since 4 assignments) storing them into the 1DArray
         */
        for (int i = 0; i < numberOfStudents; i++) {
            double temp = assignment1DArray[i];
            assignment1DArray[i] = temp/4;
        }

        /**
         * storing each element in a temp variable and dividing by 4 (since 4 practicums) storing them into the 1DArray
         */
        for (int i = 0; i < numberOfStudents; i++) {
            double temp = practicums1DArray[i];
            practicums1DArray[i] = temp/4;
        }

        /**
         * storing each element in a temp variable and storing them into the 1DArray
         */
        for (int i = 0; i < numberOfStudents; i++) {
            double temp = PoDs1DArray[i];
            PoDs1DArray[i] = temp;
        }


//        System.out.println(Arrays.toString(test1DArray));
//        System.out.println(Arrays.toString(assignment1DArray));
//        System.out.println(Arrays.toString(practicums1DArray));
//        System.out.println(Arrays.toString(PoDs1DArray));

        testAverage = testAverage*100/(300*numberOfStudents);
        assignmentAverage = assignmentAverage*100/(400*numberOfStudents);
        practicumAverage = practicumAverage*100/(400*numberOfStudents);
        PoDAverage = PoDAverage*100/(100*numberOfStudents);

        System.out.println("Class Averages: ");
        System.out.printf("Tests: %.2f", testAverage);
        System.out.printf(" - Assignments: %.2f", assignmentAverage);
        System.out.printf(" - Practicums: %.2f", practicumAverage);
        System.out.printf(" - PoDs: %.2f", PoDAverage);


        System.out.println("\nClass Medians: ");
        System.out.printf("Tests: %.2f", getMedian(test1DArray) );
        System.out.printf(" - Assignments: %.2f", getMedian(assignment1DArray));
        System.out.printf(" - Practicums: %.2f", getMedian(practicums1DArray));
        System.out.printf(" - PoDs: %.2f\n", getMedian(PoDs1DArray));

    }

    /**
     * This method converts the final grade to letter grades using the dalhousie grade conversion
     * @param finalGrade the array of final score of the students
     * @param i index of the array finalGrade
     * @return converted letter grade
     */
    public static String scoreToLetterGrade(double[] finalGrade, int i){
        String grade = "";
        if(finalGrade[i] > 90 && finalGrade[i] <= 100){
            grade = "A+";
        }
        else if(finalGrade[i] >= 85 && finalGrade[i] <= 89){
            grade = "A";
        }
        else if(finalGrade[i] >= 80 && finalGrade[i] <= 84){
            grade = "A-";
        }
        else if(finalGrade[i] >= 77 && finalGrade[i] <= 79){
            grade = "B+";
        }
        else if(finalGrade[i] >= 73 && finalGrade[i] <= 76){
            grade = "B";
        }
        else if(finalGrade[i] >= 70 && finalGrade[i] <= 72){
            grade = "B-";
        }
        else if(finalGrade[i] >= 65 && finalGrade[i] <= 69){
            grade = "C+";
        }
        else if(finalGrade[i] >= 60 && finalGrade[i] <= 64){
            grade = "C";
        }
        else if(finalGrade[i] >= 55 && finalGrade[i] <= 59){
            grade = "C-";
        }
        else if(finalGrade[i] >= 50 && finalGrade[i] <= 54){
            grade = "D";
        }
        else if(finalGrade[i] >= 0 && finalGrade[i] <= 49){
            grade = "F";
        }
        return grade;
    }

    /**
     * This method calculates the median for each assessment
     * @param marks the 1DArray consisting of respective assessment marks
     * @return median of the respective assessment
     */
    public static double getMedian(double[] marks){
        double median = 0;
        double copyOfArray[] = Arrays.copyOf(marks,marks.length);
        Arrays.sort(copyOfArray);
//        System.out.println();
//        System.out.print(Arrays.toString(marks));
//        System.out.println();
//        System.out.print(Arrays.toString(copyOfArray)+"\n");
        int length = marks.length;
        length -= 1;
//        System.out.println(length);
//        System.out.println(copyOfArray[length/2]);
//        System.out.println(copyOfArray[(length+1)/2]);

        if(marks.length%2 == 0){
            median = (copyOfArray[length/2] + copyOfArray[(length+1)/2]) / 2;
        }
        if(marks.length%2 == 1){
            median = copyOfArray[(length)/2];
        }
        return median;
    }
}