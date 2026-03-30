package stack_data_structure;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res.add(i + 1);
            } else {
                res.add(i - stack.peek());
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 80, 90, 120 };
        System.out.println("Output: " + calculateSpan(arr));
    }
}
