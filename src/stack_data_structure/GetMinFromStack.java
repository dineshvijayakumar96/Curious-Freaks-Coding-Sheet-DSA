package stack_data_structure;

import java.util.Stack;

public class GetMinFromStack {

    public static class SpecialStack {
        private Stack<Integer> stack;
        private int min;

        public SpecialStack() {
            this.stack = new Stack<>();
            this.min = -1;
        }

        public void push(int x) {
            // Add an element to the top of Stack
            if (isEmpty()) {
                min = x;
                stack.push(x);
            } else if (x < min) {
                stack.push(2 * x - min);
                min = x;
            } else {
                stack.push(x);
            }
        }

        public void pop() {
            // Remove the top element from the Stack
            if (isEmpty()) {
                return;
            }
            int top = stack.pop();
            if (top < min) {
                min = 2 * min - top;
            }
        }

        public int peek() {
            // Returns top element of the Stack
            if (isEmpty()) return -1;
            int top = stack.peek();
            return Math.max(min, top);
        }

        boolean isEmpty() {
            // Check if the stack is empty
            return (stack.isEmpty());
        }

        public int getMin() {
            // Finds minimum element of Stack
            if (isEmpty()) return -1;
            return min;
        }
    }

    public static void main(String[] args) {
        SpecialStack stack1 = new SpecialStack();
        stack1.push(2);
        stack1.push(3);
        System.out.println("Peek (Expected 3): " + stack1.peek());
        stack1.pop();
        System.out.println("Min (Expected 2): " + stack1.getMin());
        stack1.push(1);
        System.out.println("Min (Expected 1): " + stack1.getMin());

        SpecialStack stack2 = new SpecialStack();
        stack2.push(5);
        stack2.push(2);
        stack2.push(2);
        stack2.push(7);
        System.out.println("Min (Expected 2): " + stack2.getMin());
        stack2.pop();
        stack2.pop();
        System.out.println("Min (Expected 2): " + stack2.getMin());
        stack2.pop();
        System.out.println("Min (Expected 5): " + stack2.getMin());
    }
}
