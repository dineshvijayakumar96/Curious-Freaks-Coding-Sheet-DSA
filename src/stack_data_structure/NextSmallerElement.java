package stack_data_structure;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {

    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>(arr);
        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.set(i, stack.peek());
            } else {
                res.set(i, -1);
            }
            stack.push(arr.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(1);
        System.out.println("Output: " + nextSmallerElement(arr));
    }
}
