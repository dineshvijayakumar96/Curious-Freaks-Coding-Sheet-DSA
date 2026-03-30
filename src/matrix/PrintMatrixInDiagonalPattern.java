package matrix;

import java.util.Arrays;

public class PrintMatrixInDiagonalPattern {

    public static int[] matrixInDiagonal(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n*n];
        int i = 0, j = 0, index = 0;
        boolean up = true;
        while (index < (n * n)) {
            if (up) {
                while (i >= 0 && j < n) {
                    result[index++] = matrix[i][j];
                    if (j == n - 1) {
                        i++;
                        break;
                    } else if (i == 0) {
                        j++;
                        break;
                    }
                    i--;
                    j++;
                }
                up = false;
            } else {
                while (i < n && j >= 0) {
                    result[index++] = matrix[i][j];
                    if (i == n - 1) {
                        j++;
                        break;
                    } else if (j == 0) {
                        i++;
                        break;
                    }
                    i++;
                    j--;
                }
                up = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        System.out.println("Output: " + Arrays.toString(matrixInDiagonal(matrix)));
    }
}
