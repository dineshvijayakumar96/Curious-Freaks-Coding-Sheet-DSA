package stack_data_structure;

public class ImplementStackUsingArray {

    public static class myStack {
        private int[] arr;
        private int top;
        private int capacity;

        public myStack(int n) {
            this.capacity = n;
            this.arr = new int[n];
            this.top = -1;
        }

        public void push(int x) {
            if (!isFull()) {
                top++;
                arr[top] = x;
            }
        }

        public int pop() {
            if (isEmpty()) return -1;
            int element = arr[top];
            top--;
            return element;
        }

        public int peek() {
            if (isEmpty()) return -1;
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return (top == (capacity - 1));
        }
    }

    public static void main(String[] args) {
        myStack stack1 = new myStack(3);

        stack1.push(5);
        System.out.println("push(5)");

        stack1.push(3);
        System.out.println("push(3)");

        System.out.println("peek(): " + stack1.peek());
        System.out.println("pop(): " + stack1.pop());
        System.out.println("isEmpty(): " + stack1.isEmpty());
        System.out.println("isFull(): " + stack1.isFull());
        System.out.println();

        myStack stack2 = new myStack(1);

        System.out.println("pop(): " + stack2.pop());
        System.out.println("peek(): " + stack2.peek());
        System.out.println("isEmpty(): " + stack2.isEmpty());

        stack2.push(9);
        System.out.println("push(9)");

        System.out.println("isFull(): " + stack2.isFull());
    }
}
