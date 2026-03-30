package binary_search;

public class KthSmallestNumberInMultiplicationTable {

    public static int findKthElement(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isMinimumOrEqual(m, n, mid) >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int isMinimumOrEqual(int m, int n, int mid) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid/i, n);
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 3, n = 3, k = 5;
        System.out.println("Output: " + findKthElement(m, n, k));
    }
}
