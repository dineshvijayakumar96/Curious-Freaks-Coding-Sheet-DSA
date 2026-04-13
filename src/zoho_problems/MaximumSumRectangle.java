package zoho_problems;

public class MaximumSumRectangle {

    public static int maxRectSum(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int maxRectangleSum = Integer.MIN_VALUE;
        for (int left = 0; left < C; left++) {
            int[] temp = new int[R];
            for (int right = left; right < C; right++) {
                for (int i = 0; i < R; i++) {
                    temp[i] += mat[i][right];
                }
                int currentMaxRectangleSum = kadane(temp);
                maxRectangleSum = Math.max(maxRectangleSum, currentMaxRectangleSum);
            }
        }
        return maxRectangleSum;
    }

    private static int kadane(int[] arr) {
        int sum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int [][] mat = { {1, 2, -1, -4, -20}, {-8, -3, 4, 2, 1}, {3, 8, 10, 1, 3}, {-4, -1, 1, 7, -6} };
        System.out.println("Output: " + maxRectSum(mat));
    }
}
