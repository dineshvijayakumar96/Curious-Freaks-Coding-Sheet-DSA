package zoho_problems;

import java.util.Arrays;

public class MakeADistinctDigitArray {

    public static int[] common_digits(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        boolean[] numbers = new boolean[10];
        int count = 0;
        for (int num : nums) {
            while (num > 0) {
                if (!numbers[num % 10]) {
                    numbers[num % 10] = true;
                    count++;
                }
                num /= 10;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]) {
                result[index++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 131, 11, 48 };
        System.out.println(Arrays.toString(common_digits(nums)));
    }
}
