package sliding_window;

public class CountNumberOfNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        int[] counts = new int[nums.length + 1];
        counts[0] = 1;
        int currentTotal = 0;
        int niceSubarrays = 0;
        for (int i = 0; i < nums.length; i++) {
            currentTotal += (nums[i] % 2);
            int pastTotalNeeded = currentTotal - k;
            if (pastTotalNeeded >= 0) {
                niceSubarrays += counts[pastTotalNeeded];
            }
            counts[currentTotal]++;
        }
        return niceSubarrays;
    }

    public static void main(String[] args) {
        int[] nums = { 1,1,2,1,1 };
        int k = 3;
        System.out.printf("Output: " + numberOfSubarrays(nums, k));
    }
}
