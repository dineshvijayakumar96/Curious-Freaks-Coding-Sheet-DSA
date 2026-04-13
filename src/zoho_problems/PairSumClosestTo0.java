package zoho_problems;

import java.util.Arrays;

public class PairSumClosestTo0 {

    public static int closestToZero(int[] arr, int n) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
            } else if (Math.abs(sum) == Math.abs(closestSum)) {
                closestSum = Math.max(closestSum, sum);
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                return 0;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr = { -8, -66, -60 };
        int n = arr.length;
        System.out.println("Output: " + closestToZero(arr, n));
    }
}
