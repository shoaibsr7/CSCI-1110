import java.util.Scanner;

/**
 * This program takes number of minutes active in a day and calculates the total activity minutes in a month and
 * calculates average activity time.
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //creating array to store number of days in each month
        int months_array[] = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int month = in.nextInt();
        int month_days = months_array[month];

        int days = in.nextInt();
        int activity = 0;
        int sum = 0;
        double average = 0;

        while(days != 0)
        {
            activity = in.nextInt();
            //discard the activity if the day is more than the number of days in that month or less than 0
            if(days <= month_days && days > 0)
            {
                //total activity time will be calculated
                sum += activity;
            }
            days = in.nextInt();

        }
        average = (double)sum*100/(month_days*24*60);

        System.out.print("On month #" + month + ", you were active " + sum + " minutes or ");
        System.out.printf("%.2f%% of the time.\n", average);

    }
}



import java.util.Scanner;

/**
 * CSCI 1110 W2021 A0 - Keeping track of active minutes in a month
 * @author Juliano Franz
 *
 */

public class Problem1 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int month = kb.nextInt();
        int daysInMonth = -1;

        if(month == 2){
            daysInMonth = 28;
        }
        else if(month % 2 == 0 && month < 8){
            daysInMonth = 30;
        }
        else if(month %2 != 0 && month >8) {
            daysInMonth = 30;
        }
        else {
            daysInMonth = 31;
        }

        int[] activeMinutesMonth = new int[daysInMonth];

        int day = kb.nextInt();
        int totalExercise = 0;
        while (day != 0){
            int exerciseMinutes = kb.nextInt();
            if(day >0 && day <= daysInMonth){
                activeMinutesMonth[day-1] += exerciseMinutes;
                totalExercise += exerciseMinutes;
            }
            day = kb.nextInt();
        }

        System.out.printf("On month #%d, you were active %d minutes or %.2f%% of the time.\n",
                month, totalExercise, 100*(double)totalExercise/(daysInMonth * 24 * 60));

    }
}