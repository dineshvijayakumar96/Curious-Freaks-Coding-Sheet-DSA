package binary_search;

public class SearchInASortedMatrix {

    public static boolean findTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][col - 1] >= target) {
                return (binarySearch(matrix[i], target) != -1);
            }
        }
        return false;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 5, 9}, {14, 20, 21}, {30, 34, 43} };
        int target = 14;
        System.out.println("Output: " + findTarget(matrix, target));
    }
}
