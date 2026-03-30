package binary_search;

public class PeakElement {

    public static int findPeak(int[] arr) {
        if (arr.length == 1) return 0;
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 7, 8, 3 };
        System.out.println("Output: " + findPeak(arr));
    }
}
