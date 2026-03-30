package matrix;

public class RotateEachRowOfMatrixKTimes {

    public static int[][] rotateMatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
//        int[][] result = new int[n][m];
        k %= m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2 + 1; j++) {
//                result[i][j] = matrix[i][(j + k) % m];
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][(j + k) % m];
                matrix[i][(j + k) % m] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3}, {4,5,6}, {7,8,9} };
        int k = 1;
        matrix = rotateMatrix(matrix, k);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
