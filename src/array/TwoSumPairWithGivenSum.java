package array;

import java.util.HashSet;
import java.util.Set;

public class TwoSumPairWithGivenSum {

    public static boolean findTwoSumPair(int[] arr, int target) {

        if (arr == null || arr.length < 2) return false;
        Set<Integer> seenNumbers = new HashSet<>();
        for (int j : arr) {
            int difference = target - j;
            if (seenNumbers.contains(difference)) {
                return true;
            } else {
                seenNumbers.add(j);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = { 10, -10, 3, 6, 0, -3, -9, -3 };
        int target = -6;
        System.out.println("Output: " + findTwoSumPair(arr, target));
    }
}
