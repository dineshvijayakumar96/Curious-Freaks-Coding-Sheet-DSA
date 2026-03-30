package binary_search;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean possible(int[] piles, int bananas, int maxHours) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] + bananas - 1) / bananas;
        }
        return hours <= maxHours;
    }

    public static void main(String[] args) {
        int[] arr = { 30,11,23,4,20 };
        int h = 6;
        System.out.println("Output: " + minEatingSpeed(arr, h));
    }
}
