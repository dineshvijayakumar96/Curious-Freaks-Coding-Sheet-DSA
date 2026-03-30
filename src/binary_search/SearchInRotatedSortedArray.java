package binary_search;

public class SearchInRotatedSortedArray {

    public static int findTarget(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            //Left Sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                }  else {
                    low = mid + 1;
                }
            } else { //Right Sorted
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 4,5,6,7,0,1,2 };
        int target = 0;
        System.out.println("Output: " + findTarget(arr, target));
    }
}
