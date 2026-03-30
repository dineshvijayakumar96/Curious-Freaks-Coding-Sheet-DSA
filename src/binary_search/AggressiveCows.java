package binary_search;

import java.util.Arrays;

public class AggressiveCows {

    public static int findMinDistance(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlace(stalls, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canWePlace(int[] stalls, int distance, int cows) {
        int countCows = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= distance) {
                countCows++;
                last = stalls[i];
            }
            if (countCows >= cows) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stalls = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        System.out.println("Output: " + findMinDistance(stalls, k));
    }
}
