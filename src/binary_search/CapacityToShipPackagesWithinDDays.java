package binary_search;

public class CapacityToShipPackagesWithinDDays {

    public static int leastWeightCapacity(int[] arr, int n, int d) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(arr, mid, d)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean possible(int[] arr, int maxWeight, int maxDays) {
        int weight = 0, totalDays = 1;
        for (int i = 0; i < arr.length; i++) {
            if ((weight + arr[i]) <= maxWeight) {
                weight += arr[i];
            } else {
                totalDays++;
                weight = arr[i];
            }
        }
        return totalDays <= maxDays;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 8, 10 };
        int n = arr.length;
        int d = 3;
        System.out.println("Output: " + leastWeightCapacity(arr, n, d));
    }
}
