package zoho_problems;

import java.util.Arrays;

public class SmallestGreaterElementsInWholeArray {

    public static int[] greaterElement(int[] arr) {
        int n = arr.length;
        int[] sortedCopy = arr.clone();
        Arrays.sort(sortedCopy);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = upperBound(sortedCopy, arr[i]);
        }
        return result;
    }

    private static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -10000000;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 8, 10, 2, 1, 15, 7 };
        System.out.println("Output: " + Arrays.toString(greaterElement(arr)));
    }
}
