package sliding_window;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int windowLeft = 0;
        int length = 0;
        int countZeros = 0;
        for (int windowRight = 0; windowRight < nums.length; windowRight++) {
            if (nums[windowRight] == 0) {
                countZeros++;
            }
            if (countZeros > k) {
                if (nums[windowLeft] == 0) {
                    countZeros--;
                }
                windowLeft++;
            }
            if (windowRight - windowLeft + 1 > length) {
                length = windowRight - windowLeft + 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 };
        int k = 3;
        System.out.printf("Output: " + longestOnes(nums, k));
    }
}
