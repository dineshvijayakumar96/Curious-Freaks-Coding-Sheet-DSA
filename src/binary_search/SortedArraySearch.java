package binary_search;

public class SortedArraySearch {

    public static Boolean searchK(int[] arr, int k) {
        if (arr == null || arr.length == 0) return false;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                return true;
            }
            if (arr[mid] < k) {
                low = mid + 1;
            }
            if (arr[mid] > k) {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6 };
        int k = 1;
        System.out.println("Output: " + searchK(arr, k));
    }
}
