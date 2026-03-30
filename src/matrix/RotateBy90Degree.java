package matrix;

public class RotateBy90Degree {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //Reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][(n - j) - 1];
                matrix[i][(n - j) - 1] = temp;
            }
        }
        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("Output: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
        int[][] matrix = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        rotate(matrix);
    }
}
