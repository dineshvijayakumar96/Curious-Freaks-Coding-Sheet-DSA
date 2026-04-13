package zoho_problems;

import java.util.Arrays;

public class SumInAMatrix {

    public static int matrixSum(int[][] nums) {
        int m = nums[0].length;
        int sum = 0;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        for (int i = 0; i < m; i++) {
            int maxDigit = 0;
            for (int[] num : nums) {
                maxDigit = Math.max(maxDigit, num[i]);
            }
            sum += maxDigit;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = { {7,2,1}, {6,4,2}, {6,5,3}, {3,2,1} };
        System.out.println("Output: " + matrixSum(nums));
    }
}
