package stack_data_structure;

public class TwoStacksInAnArray {

    public static class twoStacks {
        private int size;
        private int[] arr;
        private int top1;
        private int top2;

        public twoStacks() {
            this.size = 1000;
            this.arr = new int[size];
            this.top1 = -1;
            this.top2 = size;
        }

        public void push1(int x) {
            // code here
            if (top1 < (top2 - 1)) {
                top1++;
                arr[top1] = x;
            }
        }

        // Function to push an integer into the stack2.
        public void push2(int x) {
            // code here
            if (top1 < (top2 - 1)) {
                top2--;
                arr[top2] = x;
            }
        }

        // Function to remove an element from top of the stack1.

        public int pop1() {
            // code here
            if (top1 >= 0) {
                int element = arr[top1];
                top1--;
                return element;
            } else {
                return -1;
            }
        }

        // Function to remove an element from top of the stack2.
        public int pop2() {
            // code here
            if (top2 < size && top2 > top1) {
                int element = arr[top2];
                top2++;
                return element;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        twoStacks ts = new twoStacks();

        ts.push1(2);
        ts.push1(3);
        ts.push2(4);

        System.out.println("pop1(): " + ts.pop1());
        System.out.println("pop2(): " + ts.pop2());
        System.out.println("pop2(): " + ts.pop2());
    }
}
