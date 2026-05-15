package zoho_problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class KSizedSubarrayMaximum {

    public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] <= arr[i]) {
                stack.removeLast();
            }
            stack.addLast(i);
            if (!stack.isEmpty() && stack.peekFirst() == i - k) {
                stack.removeFirst();
            }
            if (!stack.isEmpty() && i >= (k - 1)) {
                result.add(arr[stack.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        System.out.println("Output: " + maxOfSubarrays(arr, k));
    }
}
