package sliding_window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {

    public static List<Integer> firstNegInt(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                queue.add(i);
            }
            if (!queue.isEmpty() && queue.peek() < (i - k + 1)) {
                queue.poll();
            }
            if (i >= k - 1) {
                if (!queue.isEmpty()) {
                    answer.add(arr[queue.peek()]);
                } else {
                    answer.add(0);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { -8, 2, 3, -6, 10 };
        int k = 2;
        System.out.println("Output: " + firstNegInt(arr, k));
    }
}
