package queue;

import java.util.Stack;

public class QueueUsingTwoStacks {

    public static class StackQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public StackQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int B) {
            // code here
            this.stack1.push(B);
        }

        public int pop() {
            // code here
            if (this.stack1.isEmpty() && this.stack2.isEmpty()) return -1;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    this.stack2.push(stack1.pop());
                }
            }
            return this.stack2.pop();
        }
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(2);
        System.out.println("Added element: " + 2);
        stackQueue.push(3);
        System.out.println("Added element: " + 3);
        int temp = stackQueue.pop();
        System.out.println("Popped Element: " + temp);
        stackQueue.push(4);
        System.out.println("Added element: " + 4);
        temp = stackQueue.pop();
        System.out.println("Popped Element: " + temp);
        temp = stackQueue.pop();
        System.out.println("Popped Element: " + temp);
    }
}
