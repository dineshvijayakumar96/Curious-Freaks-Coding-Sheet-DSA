package sliding_window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class KSizedSubarrayMaximum {

    public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peekFirst() == (i - k)) {
                stack.pollFirst();
            }
            while (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]) {
                stack.pollLast();
            }
            stack.addLast(i);
            if (!stack.isEmpty() && i >= (k - 1)) {
                answer.add(arr[stack.peekFirst()]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        System.out.println("Output: " + maxOfSubarrays(arr, k));
    }
}
