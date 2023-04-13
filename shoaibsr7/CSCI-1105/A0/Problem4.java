import java.util.Arrays;
import java.util.Scanner;

/**
 * This program takes number of minutes active in a day and calculates the total activity minutes in a month and
 * calculates average activity time and then calculates the most active day and total activity that day
 * and prints a bar graph.
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int monthsArray[] = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = in.nextInt();
        int DaysOfMonth = monthsArray[month];

        int days = in.nextInt();
        int activity = 0;
        int sum = 0;
        double average = 0;
        int counter = 0;

        /* creating an array that stores total activity minutes for each day at index = day – 1
         * since days in the program start at 1 and index needs to start at 0
         */
        int activityMinutesArray[] = new int[DaysOfMonth];

        while (days != 0) {
            activity = in.nextInt();
            if (days <= DaysOfMonth && days > 0) {
                /**
                 * instead of just copying the activity minutes, we need to add it to the current activity minutes
                 * already in the corresponding index since days number can be repeated in given input
                 */
                activityMinutesArray[days - 1] += activity;
                sum += activity;
            }
            days = in.nextInt();
        }

        average = (double) sum * 100 / (DaysOfMonth * 24 * 60);

        System.out.print("On month #" + month + ", you were active " + sum + " minutes or ");
        System.out.printf("%.2f%% of the time.\n", average);

        // printing the most active day and then the maximum activity minutes
        int mostActiveDay = mostActiveDay(activityMinutesArray);
        System.out.println("You were most active on day " + mostActiveDay + " with " + activityMinutesArray[mostActiveDay - 1] + " minutes");

        barGraph(activityMinutesArray, activityMinutesArray[mostActiveDay - 1], DaysOfMonth);
    }

    /**
     * using 2 d array.
     * the number of rows will be activity_array[mostActiveDay - 1]/10
     * the number of columns will be numbers of days in the month
     * to print dates array[activity_array[(mostActiveDay - 1]/10) + 1][i]
     * to print stars array[i][mostActiveDay]
     * @param array the array containing the activity minutes
     * @param mostActivityMins the highest number of activity minutes
     * @param daysMonth number of days in the month
     */
    public static void barGraph(int[] array, int mostActivityMins, int daysMonth) {
        /**
         * Storing the chart, for example
         * 1 2 3 4 .... daysMonth <-- days
         * *   * *
         * *
         * stars = number of activity minutes - 1
         * we will first initialize this 2d array,
         * and then print it as the desired output
         * */
        String[][] chart = new String[mostActivityMins/10 + 1][daysMonth];

        /**
         * we start by setting the first row in the 2d array to the days number (1 to daysMonth)
         * */
        for (int i = 1; i <= daysMonth; i++) {
            chart[0][i-1] = Integer.toString(i);
        }

        /**
         * then we set, all other values (except those in the first row) in the chart to
         * a space since the default value of a string is null
         * and if needed this space will be replaced with a star.
         * this allows us to not worry about printing the null and directly print a space instead
         * */
        for (int i = 1; i < chart.length; i++) {
            for (int j = 0; j < daysMonth; j++) {
                chart[i][j] = " ";
            }
        }

        /**
         * now, we start setting the stars
         * remember the maximum number of stars = max number of activity minutes / 10
         * and that is exactly how many rows we have in the chart + 1 (for the days number row)
         * so, we use these nested loops to set the stars by looping through each column
         * and setting the next activityMinutes/10 rows to * (note first row is taken so we start at 1)
         * */
        for (int i = 0; i < daysMonth; i++) {
            for (int j = 1; j <= (array[i]/10); j++) {
                chart[j][i] = "*";
            }
        }

        /**
         * finally we print the chart, but as per the requirements we need to print the last row first
         * and then the second last and so on i.e., we print the rows of the chart in reverse order
         * (the order of columns remains the same so that starts at 0)
         * */
        for (int i = chart.length - 1; i >= 0; i--) {
            for (int j = 0; j < daysMonth; j++) {
                System.out.format("%3s", chart[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * this method is going to return the day on which the activity minutes is maximum and we will use
     * that in the main method to also get the maximum activity minutes
     *
     * @param array the array containing the activity minutes
     * @return the most active minute
     */
    public static int mostActiveDay(int[] array) {
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

public class Problem4 {
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

        //Q2 25 points - most active day
        int mostActiveDay = 1;
        int mostActiveDayMinutes = activeMinutesMonth[0];
        for (int i = 0; i < daysInMonth; i++) {
            if(mostActiveDayMinutes < activeMinutesMonth[i]){
                mostActiveDay = i+1;
                mostActiveDayMinutes = activeMinutesMonth[i];
            }
        }

        System.out.printf("You were most active on day %d with %d minutes\n", mostActiveDay,mostActiveDayMinutes);

        String[][] barChart = new String[mostActiveDayMinutes/10+1][daysInMonth];
        for (int i = 0; i < daysInMonth; i++) {
            barChart[0][i] = String.format("%3s", i+1);
        }
        for (int i = 0; i < daysInMonth; i++) {
            for (int j = 1; j < activeMinutesMonth[i]/10 + 1; j++) {
                barChart[j][i] = "*";
            }
        }

        for (int i = barChart.length-1; i >= 0; i--) {
            for (int j = 0; j < barChart[0].length; j++) {
                if(barChart[i][j] == null){
                    System.out.printf("%3s", "");
                }
                else {
                    System.out.printf("%3s", barChart[i][j]);
                }
            }
            System.out.println();
        }
    }

}
