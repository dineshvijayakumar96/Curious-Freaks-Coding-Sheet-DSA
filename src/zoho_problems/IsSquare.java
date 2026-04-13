package zoho_problems;

import java.util.Arrays;

public class IsSquare {

    public static String isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        long[] distances = new long[6];
        distances[0] = distanceSquare(x1, y1, x2, y2);
        distances[1] = distanceSquare(x1, y1, x3, y3);
        distances[2] = distanceSquare(x1, y1, x4, y4);
        distances[3] = distanceSquare(x2, y2, x3, y3);
        distances[4] = distanceSquare(x2, y2, x4, y4);
        distances[5] = distanceSquare(x3, y3, x4, y4);
        Arrays.sort(distances);
        if (distances[0] > 0 && distances[0] == distances[1] && distances[1] == distances[2] &&
        distances[2] == distances[3] && distances[4] == distances[5] && (distances[0] + distances[1]) == distances[4]) {
            return "Yes";
        }
        return "No";
    }

    private static long distanceSquare(int x1, int y1, int x2, int y2) {
        return (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2);
    }

    public static void main(String[] args) {
        int x1 = 20, y1 = 10, x2 = 10, y2 = 20;
        int x3 = 20, y3 = 20, x4 = 10, y4 = 10;
        System.out.println("Output: " + isSquare(x1, y1, x2, y2, x3, y3, x4, y4));
    }
}
