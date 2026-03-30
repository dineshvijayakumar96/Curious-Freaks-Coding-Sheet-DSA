package binary_search;

public class FindTheSmallestDivisorGivenAThreshold {

    public static int findTheDivisor(int[] nums, int threshold) {
        int low = 1, high = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(nums[i], high);
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (sumOfDivisions(nums, mid) > threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int sumOfDivisions(int[] nums, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + (nums[i] + divisor - 1) / divisor;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,5,9 };
        int threshold = 6;
        System.out.println("Output: " + findTheDivisor(nums, threshold));
    }
}
