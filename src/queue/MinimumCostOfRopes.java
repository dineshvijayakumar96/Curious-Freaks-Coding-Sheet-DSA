package queue;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public static int minCost(int[] arr) {
        if (arr.length <= 1) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long j : arr) {
            pq.add(j);
        }
        long totalCost = 0;
        while (pq.size() > 1) {
            long firstSmallest = pq.poll();
            long secondSmallest = pq.poll();
            long sum = firstSmallest + secondSmallest;
            totalCost += sum;
            pq.add(sum);
        }
        return (int) totalCost;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 6 };
        System.out.println("Output: " + minCost(arr));
    }
}
