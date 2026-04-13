package zoho_problems;

import java.util.HashSet;

public class TwoSumPairWithGivenSum {

    public static boolean twoSum(int[] arr, int target) {
        if (arr == null || arr.length <= 1) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            int key = target - j;
            if (set.contains(key)) {
                return true;
            } else {
                set.add(j);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;
        System.out.println("Output: " + twoSum(arr, target));
    }
}
