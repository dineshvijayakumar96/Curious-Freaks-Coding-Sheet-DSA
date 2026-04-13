package zoho_problems;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            arr[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(current);
        }
        for (int j : arr) {
            result.add(j);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 1 };
        System.out.println("Output: " + nextLargerElement(arr));
    }
}
