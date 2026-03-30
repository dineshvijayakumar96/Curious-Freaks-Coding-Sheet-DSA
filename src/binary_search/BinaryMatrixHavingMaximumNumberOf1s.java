package binary_search;

import java.util.Arrays;

public class BinaryMatrixHavingMaximumNumberOf1s {

    public static int[] findMaxRow(int[][] matrix) {
        int  row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[2];
        int r = 0, c = 0, max = Integer.MIN_VALUE, rowIndex = -1;
        for (int i = 0; i < row; i++) {
            int index = lowerBound(matrix[i], 1);
            int sum = col - index;
            if (sum > max) {
                max = sum;
                rowIndex = i;
            }
        }
        result[0] = rowIndex;
        result[1] = max;
        return result;
    }

    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = { {0, 0, 1}, {0, 1, 1}, {0, 0, 0} };
        System.out.println("Output: " + Arrays.toString(findMaxRow(matrix)));
    }
}
