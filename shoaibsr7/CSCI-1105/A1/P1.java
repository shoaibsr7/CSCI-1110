/**
 * This program calculates the final mark of one student and converts them to their respective grades using a method
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
import java.util.Arrays;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //initializing variables
        String idNumber = in.next();
        int test [] = new int[400];
        int assignment [] = new int[5];
        int practicums [] = new int[400];
        double PoDs = 0;
        double marksForTest = 0;
        double marksForAssignment = 0;
        double marksForPracticum = 0;
        double finalMarks = 0;

        //using a for loop to store data from the user into the array then adding each element at index i and storing
        //the sum in marksForTest
        for (int i = 0; i < 3; i++) {
            test[i] = in.nextInt();
            marksForTest += test[i];
        }

        //using a for loop to store data from the user into the array
        for (int i = 0; i < 5; i++) {
            assignment[i] = in.nextInt();
        }
        //using Arrays.sort() to sort the array in ascending order
        Arrays.sort(assignment);
        //since we drop the lowest grade which is now at index 0 we add the marks from index 1 to 4
        for (int i = 1; i < 5; i++) {
            marksForAssignment += assignment[i];
        }

        //using a for loop to store data from the user into the array then adding each element at index i and storing
        //the sum in marksForPracticum
        for (int i = 0; i < 4; i++) {
            practicums[i] = in.nextInt();
            marksForPracticum += practicums[i];
        }

        //storing the pod marks in PoDs
        PoDs = in.nextInt();

        //calculation of each assessment
        PoDs = PoDs*0.1;
        marksForTest = marksForTest/3*0.25;
        //divide by 4 because we drop the lowest score
        marksForAssignment = marksForAssignment/4*0.30;
        marksForPracticum = marksForPracticum/4*0.35;

        finalMarks = marksForTest + marksForAssignment + marksForPracticum + PoDs;
        finalMarks = Math.floor(finalMarks);
        System.out.println("Student: "+idNumber+ " - " +scoreToLetterGrade(finalMarks));
    }

    /**
     * This method converts the final grade to letter grades using the dalhousie grade conversion
     * @param finalGrade the final score of the student
     * @return converted letter grade
     */
    public static String scoreToLetterGrade(double finalGrade){
        String grade = "";
        if(finalGrade > 90 && finalGrade <= 100){
            grade = "A+";
        }
        else if(finalGrade >= 85 && finalGrade <= 89){
            grade = "A";
        }
        else if(finalGrade >= 80 && finalGrade <= 84){
            grade = "A-";
        }
        else if(finalGrade >= 77 && finalGrade <= 79){
            grade = "B+";
        }
        else if(finalGrade >= 73 && finalGrade <= 76){
            grade = "B";
        }
        else if(finalGrade >= 70 && finalGrade <= 72){
            grade = "B-";
        }
        else if(finalGrade >= 65 && finalGrade <= 69){
            grade = "C+";
        }
        else if(finalGrade >= 60 && finalGrade <= 64){
            grade = "C";
        }
        else if(finalGrade >= 55 && finalGrade <= 59){
            grade = "C-";
        }
        else if(finalGrade >= 50 && finalGrade <= 54){
            grade = "D";
        }
        else if(finalGrade >= 0 && finalGrade <= 49){
            grade = "F";
        }
        return grade;
    }
}
