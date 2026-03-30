package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKOfAQueue {

    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (k > q.size()) return q;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        int remaining = q.size() - k;
        for (int i = 0; i < remaining; i++) {
            q.add(q.poll());
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(7);
        queue.offer(7);
        queue.offer(5);
        queue.offer(6);
        queue.offer(5);
        queue.offer(10);
        int k = 8;
        queue = reverseFirstK(queue, k);
        System.out.println(queue);
    }
}
