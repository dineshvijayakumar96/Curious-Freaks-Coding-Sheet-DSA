package binary_search;

public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } else {
                //Left Sorted
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target <= nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else { //Right Sorted
                    if (nums[mid] <= target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 3,1 };
        int target = 1;
        System.out.println("Output: " + search(arr, target));
    }
}
