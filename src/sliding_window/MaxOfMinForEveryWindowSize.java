package sliding_window;

import java.util.ArrayList;
import java.util.Stack;

public class MaxOfMinForEveryWindowSize {

    public static ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        //Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        //Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            ans[windowSize] = Math.max(ans[windowSize], arr[i]);
        }
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        for (int i = 1; i <= n; i++) {
            result.add(ans[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
        System.out.println("Output: " + maxOfMins(arr));
    }
}
