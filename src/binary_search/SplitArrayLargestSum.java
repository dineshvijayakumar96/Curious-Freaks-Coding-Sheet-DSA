package binary_search;

public class SplitArrayLargestSum {

    public static int findMin_MaxValue(int[] arr, int k) {
        long low = 0, high = 0;
        for (int i = 0; i < arr.length; i++) {
            high += arr[i];
            if (arr[i] > low) {
                low = arr[i];
            }
        }
        long result = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long noOfSplits = findNoOfSplits(arr, mid);
            if (noOfSplits > k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return (int) result;
    }

    public static long findNoOfSplits(int[] arr, long max) {
        long count = 1, totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (totalSum + arr[i] <= max) {
                totalSum += arr[i];
            } else {
                count++;
                totalSum = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        int k = 2;
        System.out.println("Output: " + findMin_MaxValue(arr, k));
    }
}
