package zoho_problems;

import java.util.Arrays;

public class RotateBy90Degree {

    public static void rotateMatrix(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} };
        rotateMatrix(mat);
        System.out.println("Output: " + Arrays.deepToString(mat));
    }
}
