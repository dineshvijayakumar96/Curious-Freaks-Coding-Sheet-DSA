package array;

import java.util.Arrays;

public class FindTripletsWithZeroSum {

    public static boolean tripletsWithZeroSum(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                if (sum == 0) return true;
                if (sum < 0) left++;
                else right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, -1, 2, -3, 1};
        System.out.println("Output: " + tripletsWithZeroSum(arr));
    }
}
