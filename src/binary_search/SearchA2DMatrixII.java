package binary_search;

public class SearchA2DMatrixII {

    public static boolean findTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30} };
        int target = 5;
        System.out.println("Output: " + findTarget(matrix, target));
    }
}
