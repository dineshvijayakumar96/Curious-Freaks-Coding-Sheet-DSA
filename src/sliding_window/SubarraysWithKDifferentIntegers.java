package sliding_window;

public class SubarraysWithKDifferentIntegers {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostK(nums, k) - subarraysWithAtMostK(nums, k - 1);
    }

    private static int subarraysWithAtMostK(int[] nums, int k) {
        int[] counts = new int[nums.length + 1];
        int leftWindow = 0, rightWindow = 0;
        int distinctCount = 0;
        int totalSubarrays = 0;
        while (rightWindow < nums.length) {
            if (counts[nums[rightWindow]] == 0) {
                distinctCount++;
            }
            counts[nums[rightWindow]]++;
            while (distinctCount > k) {
                counts[nums[leftWindow]]--;
                if (counts[nums[leftWindow]] == 0) {
                    distinctCount--;
                }
                leftWindow++;
            }
            totalSubarrays += (rightWindow - leftWindow + 1);
            rightWindow++;
        }
        return totalSubarrays;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,1,2,3 };
        int k = 2;
        System.out.println("Output: " + subarraysWithKDistinct(nums, k));
    }
}
