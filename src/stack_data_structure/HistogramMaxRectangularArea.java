package stack_data_structure;

import java.util.Stack;

public class HistogramMaxRectangularArea {

    public static int getMaxArea(int[] arr) {
        int[] leftSmall = new int[arr.length];
        int[] rightSmall = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            leftSmall[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            rightSmall[i] = stack.isEmpty() ? arr.length - 1 : stack.peek() - 1;
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] * ((rightSmall[i] - leftSmall[i]) + 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 7, 5, 9 };
        System.out.println("Output: " + getMaxArea(arr));
    }
}
