package queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySorted {

    public static void nearlySorted(int[] arr, int k) {
        if (arr ==  null || arr.length <= 1 || k == 0) return;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        int initialSize = Math.min(n, k + 1);
        for (int i = 0; i < initialSize; i++) {
            pq.add(arr[i]);
        }
        int targetIndex = 0;
        for (int i = k + 1; i < n; i++) {
            arr[targetIndex] = pq.poll();
            targetIndex++;
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            arr[targetIndex] = pq.poll();
            targetIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        int k = 2;
        nearlySorted(arr, k);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
