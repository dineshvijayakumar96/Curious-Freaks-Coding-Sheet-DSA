package zoho_problems;

public class KadanesAlgorithm {

    public static int maxSubarraySum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int maxSum = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println("Output: " + maxSubarraySum(arr));
    }
}
