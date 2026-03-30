package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
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
