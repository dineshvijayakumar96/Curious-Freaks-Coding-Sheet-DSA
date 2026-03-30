package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    public static class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
        }

        void push(int x) {
            // Inserts an element x at the top of the stack
            queue2.add(x);
            while(!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
            Queue<Integer> tempQueue = queue1;
            queue1 = queue2;
            queue2 = tempQueue;
        }

        void pop() {
            // Removes an element from the top of the stack
            if (queue1.isEmpty()) return;
            queue1.poll();
        }

        int top() {
            // Returns the top element of the stack
            // If stack is empty, return -1
            if (queue1.isEmpty()) return -1;
            return queue1.peek();
        }

        int size() {
            // Returns the current size of the stack
            return queue1.size();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        System.out.println("Added element: " + 5);
        stack.push(3);
        System.out.println("Added element: " + 3);
        stack.push(4);
        System.out.println("Added element: " + 4);
        stack.top();
        System.out.println("Top element: " + stack.top());
        stack.pop();
        System.out.println("Removed Top element!");
        int temp = stack.size();
        System.out.println("Stack size: " + temp);
        System.out.println("Top element: " + stack.top());
        stack.pop();
        System.out.println("Removed Top element!");
        System.out.println("Top element: " + stack.top());
    }
}
