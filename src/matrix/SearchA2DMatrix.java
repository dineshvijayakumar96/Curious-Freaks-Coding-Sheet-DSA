package matrix;

public class SearchA2DMatrix {

    public static boolean findTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = (m * n) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,3,5,7}, {10,11,16,20}, {23,30,34,60}, {70, 80, 90, 100}};
        int target = 3;
        System.out.println("Output: " + findTarget(matrix, target));
    }
}
