package zoho_problems;

public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = { 1,1,2,3,3,4,4,8,8 };
        System.out.println("Output: " + singleNonDuplicate(arr));
    }
}
