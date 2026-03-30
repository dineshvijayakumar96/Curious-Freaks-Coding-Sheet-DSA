package matrix;

public class RowWithMinimum1S {

    public static int findRow(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += matrix[i][j];
            }
            if (sum < min) {
                if (sum == 0) {
                    row = i + 1;
                    break;
                } else {
                    min = sum;
                    row = i + 1;
                }
            }
        }

        return row;
    }

    public static void main(String[] args) {
        //int[][] matrix = { {1, 1, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 1, 1} };
        int[][] matrix = { {0, 0, 1, 1, 1}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 0 ,0 ,0 ,0}, {0, 1 ,1 ,1 ,1} };
        System.out.println("Output: " + findRow(matrix));
    }
}
