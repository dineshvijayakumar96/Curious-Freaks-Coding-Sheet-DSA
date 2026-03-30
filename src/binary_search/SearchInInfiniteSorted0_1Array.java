package binary_search;

public class SearchInInfiniteSorted0_1Array {

    public static int firstOne(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int index = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println("Output: " + firstOne(arr));
    }
}
