package stack_data_structure;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = (2 * n) - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    arr[i] = stack.peek();
                } else {
                    arr[i] = -1;
                }
            }
            stack.push(nums[i % n]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] nums = { 1,2,3,4,3 };
        System.out.println("Output: " + Arrays.toString(nextGreaterElements(nums)));
    }
}
