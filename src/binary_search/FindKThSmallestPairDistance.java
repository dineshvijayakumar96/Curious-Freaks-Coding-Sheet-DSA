package binary_search;

import java.util.Arrays;

public class FindKThSmallestPairDistance {

    public static int findSmallestPair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, low = 0, high = nums[n - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int countPairs(int[] nums, int target) {
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > target) {
                left++;
            }
            count += right - left;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1,6,1 };
        int k = 5;
        System.out.println("Output: " + findSmallestPair(nums, k));
    }
}
