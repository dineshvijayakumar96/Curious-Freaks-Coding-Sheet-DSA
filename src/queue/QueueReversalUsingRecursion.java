package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReversalUsingRecursion {

    public static void reverseQueue(Queue<Integer> q){
        if (q.isEmpty()) return;
        int top = q.poll();
        reverseQueue(q);
        q.add(top);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        reverseQueue(queue);
        System.out.println(queue);
    }
}
