package array;

import java.util.HashMap;

public class LongestSubarrayWithSumK {

    public static int calculate(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            long remaining = sum - k;
            if (map.containsKey(remaining)) {
                int length = i - map.get(remaining);
                maxLength = Math.max(maxLength, length);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println("Output: " + calculate(arr, k));
    }
}
