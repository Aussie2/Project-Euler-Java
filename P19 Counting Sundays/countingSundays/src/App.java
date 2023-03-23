import java.util.HashMap;

// You are given the following information, but you may prefer to do some research for yourself.

// 1 Jan 1900 was a Monday.
// Thirty days has September,
// April, June and November.
// All the rest have thirty-one,
// Saving February alone,
// Which has twenty-eight, rain or shine.
// And on leap years, twenty-nine.
// A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
// How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        HashMap<Integer, String> months = new HashMap<>();    
        HashMap<Integer, Integer> days = new HashMap<>();
        months.put(1, "Jan");
        months.put(2, "Feb");
        months.put(3, "Mar");
        months.put(4, "Apr");
        months.put(5, "May");
        months.put(6, "Jun");
        months.put(7, "Jul");
        months.put(8, "Aug");
        months.put(9, "Sep");
        months.put(10, "Oct");
        months.put(11, "Nov");
        months.put(12, "Dec");

        days.put(1, 31);
        days.put(2, 28);
        days.put(3, 31);
        days.put(4, 30);
        days.put(5, 31);
        days.put(6, 30);
        days.put(7, 31);
        days.put(8, 31);
        days.put(9, 30);
        days.put(10, 31);
        days.put(11, 30);
        days.put(12, 31);
        int daySum = 0;
        int sundayCount = 0;
        for (int i = 1900; i < 2001; i++) {
            for (int j = 1; j < 13; j++) {
                int day = 0;
                if (j == 2 && isLeapYear(i)) {
                    day = days.get(j) + 1;
                }else{
                    day = days.get(j);
                }

                daySum += day;
                if (daySum % 7 == 0 && i > 1900) {
                    sundayCount += 1;
                }
            }
        }
        long endTime = System.nanoTime();

        System.out.printf("The number of months starting with a Sunday is: %,d%n", sundayCount);
        System.out.printf("Time taken %,dns%n", endTime-startTime);
    }

    // A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
    public static boolean isLeapYear(int year){
        if (year % 400 == 0) {
            return(true);
        }
        else if (year % 100 == 0) {
            return(false);
        }
        else if (year % 4 == 0) {
            return(true);
        }
        return(false);
    }
}
