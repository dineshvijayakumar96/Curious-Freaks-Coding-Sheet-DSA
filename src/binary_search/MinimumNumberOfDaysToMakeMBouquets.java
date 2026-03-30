package binary_search;

public class MinimumNumberOfDaysToMakeMBouquets {

    public static int findTheDay(int[] bloomDay, int m, int k) {
        long value = ((long) m) * ((long) k);
        if (value > bloomDay.length) return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean possible(int[] arr, int target, int maxBouquets, int maxFlowers) {
        int flowers = 0, bouquets = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                flowers++;
            } else {
                flowers = 0;
            }
            if (flowers >= maxFlowers) {
                bouquets++;
                flowers = 0;
            }
            if (bouquets >= maxBouquets) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2, k = 3;
        System.out.println("Output: " + findTheDay(bloomDay, m ,k));
    }
}
