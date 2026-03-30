package array;

public class MaximumProductSubarray {

    public static int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int max = arr[0], left = 1, right = 1, n = arr.length;
        for (int i = 0; i < n; i++) {
            left = (left == 0 ? 1 : left) * arr[i];
            right = (right == 0 ? 1 : right) * arr[(n - 1) - i];
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };
        System.out.println("Output: " + maxProduct(arr));
    }
}
