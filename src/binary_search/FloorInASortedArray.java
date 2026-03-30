package binary_search;

public class FloorInASortedArray {

    public static int floorOfX(int[]arr, int x) {
        if (arr == null || arr.length == 0) return -1;
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else {
                index = mid;
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        //int[] arr = { 4, 15, 17, 17, 19, 20, 21, 22, 22, 25, 26, 26, 26, 28, 28, 28, 31, 31, 32, 33, 34, 34, 35, 36, 36, 37, 38, 38, 39, 41, 41, 42, 43, 43, 44, 44, 45, 45, 46, 47, 49, 49, 50, 50, 50, 51, 53, 54, 54, 56, 57, 58, 58, 59, 60, 64, 67,69, 75, 94 };
        int[] arr = { 2 };
        int x = 6;
        System.out.println("Output: " + floorOfX(arr, x));
    }
}
