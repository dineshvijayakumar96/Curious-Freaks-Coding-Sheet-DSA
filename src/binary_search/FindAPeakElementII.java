package binary_search;

import java.util.Arrays;

public class FindAPeakElementII {

    public static int[] findPeak(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int rowMaxIndex = findMaxRow(matrix, n, mid);
            int left = (mid - 1 >= 0 ? matrix[rowMaxIndex][mid - 1] : -1);
            int right = (mid + 1 < m ? matrix[rowMaxIndex][mid + 1] : -1);
            if (matrix[rowMaxIndex][mid] > left && matrix[rowMaxIndex][mid] > right) {
                return new int[] {rowMaxIndex, mid};
            } else if (matrix[rowMaxIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }

    public static int findMaxRow(int[][] matrix, int n, int col) {
        int maxValue = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] > maxValue) {
                maxValue = matrix[i][col];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 4, 2, 5, 1, 4, 5 }, { 2, 9, 3, 2, 3, 2 }, { 1, 7, 6, 0, 1, 3 }, { 3, 6, 2, 3, 7, 2 } };
        System.out.println("Output: " + Arrays.toString(findPeak(matrix)));
    }
}
