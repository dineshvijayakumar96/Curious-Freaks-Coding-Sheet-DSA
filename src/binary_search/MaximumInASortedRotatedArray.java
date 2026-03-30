package binary_search;

public class MaximumInASortedRotatedArray {

    public static int findMaximum(int[] arr) {
        int low = 0, high = arr.length - 1, max = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                max = Math.max(max, arr[mid]);
                low = mid + 1;
            } else {
                max = Math.min(max, arr[high]);
                high = mid - 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 2, 2 };
        System.out.println("Output: " + findMaximum(arr));
    }
}
