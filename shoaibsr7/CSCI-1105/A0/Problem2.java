import java.util.Arrays;
import java.util.Scanner;

/**
 * This program takes number of minutes active in a day and calculates the total activity minutes in a month and
 * calculates average activity time and then calculates the most active day and total activity that day
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int months_array[] = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int month = in.nextInt();
        int month_days = months_array[month];

        int days = in.nextInt();
        int activity = 0;
        int sum = 0;
        double average = 0;
        int counter = 0;

        /* creating an array that stores total activity minutes for each day at index = day – 1
         * since days in the program start at 1 and index needs to start at 0
         */
        int activity_array[] = new int[month_days];

        while(days != 0)
        {
            activity = in.nextInt();
            if(days <= month_days && days > 0)
            {
                /*
                 * instead of just copying the activity minutes, we need to add it to the current activity minutes
                 * already in the corresponding index since days number can be repeated in given input
                 */
                activity_array[days - 1] += activity;
                sum += activity;
            }
            days = in.nextInt();
        }

        average = (double)sum*100/(month_days*24*60);

        System.out.print("On month #" + month + ", you were active " + sum + " minutes or ");
        System.out.printf("%.2f%% of the time.\n", average);

        // printing the most active day and then the maximum activity minutes
        int mostActiveDay = mostActiveDay(activity_array);
        System.out.println("You were most active on day " +mostActiveDay + " with " +activity_array[mostActiveDay - 1] + " minutes");
    }

    /**
     * this method is going to return the day on which the activity minutes is maximum and we will use
     * that in the main method to also get the maximum activity minutes
     * @param array the array containing the activity minutes
     * @return the most active minute
     */
    public static int mostActiveDay(int[] array){
        //initializing the max value to be at index 0
        int max_index = 0;

        //looping through array
        for (int i = 0; i < array.length; i++) {
            //checking if the value at current index i is greater than the current max value
            if (array[i] > array[max_index]) {
                //changing index of the max value to i
                max_index = i;
            }
        }
        //adding 1 to the index of max value since the days’ number at 1 but index starts at 0
        return max_index + 1;
    }
}




import java.util.Scanner;

/**
 * CSCI 1110 W2021 A0 - Keeping track of active minutes in a month

 * @author Juliano Franz
 *
 */

public class Problem2 {
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


        int mostActiveDay = 1;
        int mostActiveDayMinutes = activeMinutesMonth[0];
        for (int i = 0; i < daysInMonth; i++) {
            if(mostActiveDayMinutes < activeMinutesMonth[i]){
                mostActiveDay = i+1;
                mostActiveDayMinutes = activeMinutesMonth[i];
            }
        }

        System.out.printf("You were most active on day %d with %d minutes\n", mostActiveDay,mostActiveDayMinutes);
    }
}