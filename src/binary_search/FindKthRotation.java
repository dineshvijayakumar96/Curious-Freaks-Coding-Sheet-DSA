package binary_search;

public class FindKthRotation {

    public static int kThRotation(int[] arr) {
        int low = 0, high = arr.length - 1, min = Integer.MAX_VALUE, index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Output: " + kThRotation(arr));
    }
}
