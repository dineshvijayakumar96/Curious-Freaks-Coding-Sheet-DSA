package stack_data_structure;

import java.util.Stack;

public class HistogramMaxRectangularAreaII {

    public static int getMaxArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= arr.length; i++) {
            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                int height = arr[stack.peek()];
                stack.pop();
                int width;
                if (stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 7, 5, 9 };
        System.out.println("Output: " + getMaxArea(arr));
    }
}
