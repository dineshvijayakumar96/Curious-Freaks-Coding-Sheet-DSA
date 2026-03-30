package sliding_window;

public class MaxSumSubarrayOfSizeK {

    public static int maxSubarraySum(int[] arr, int k) {
        long maxSum = 0;
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return (maxSum >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) maxSum);
    }

    public static void main(String[] args) {
        int[] arr = { 100, 200, 300, 400 };
        int k = 2;
        System.out.println("Output: " + maxSubarraySum(arr, k));
    }
}
