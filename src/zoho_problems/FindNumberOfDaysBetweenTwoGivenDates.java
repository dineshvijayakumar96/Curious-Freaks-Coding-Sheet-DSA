package zoho_problems;

public class FindNumberOfDaysBetweenTwoGivenDates {

    public static int noOfDays(int d1, int m1, int y1, int d2, int m2, int y2) {
        int n1 = getAbsoluteDays(d1, m1, y1);
        int n2 = getAbsoluteDays(d2, m2, y2);
        return Math.abs(n1 - n2);
    }

    private static final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static int countLeapYears(int y, int m) {
        int years = y;
        if (m <= 2) {
            years--;
        }
        return (years / 4) - (years / 100) + (years / 400);
    }

    private static int getAbsoluteDays(int d, int m, int y) {
        int totalDays = y * 365 + d;
        for (int i = 0; i < m - 1; i++) {
            totalDays += monthDays[i];
        }
        totalDays += countLeapYears(y, m);
        return totalDays;
    }

    public static void main(String[] args) {
        int d1 = 10, m1 = 2, y1 = 2014;
        int d2 = 10, m2 = 3, y2 = 2015;
        System.out.println("Output: " + noOfDays(d1, m1, y1, d2, m2, y2));
    }
}
