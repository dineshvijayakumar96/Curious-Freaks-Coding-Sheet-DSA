package queue;

public class QueueUsingLinkedList {

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class myQueue {

        private Node head;
        private Node tail;
        private int count;

        public myQueue() {
            // Initialize your data members
            this.head = null;
            this.tail = null;
            this.count = 0;
        }

        public boolean isEmpty() {
            // check if the queue is empty
            return this.head == null;
        }

        public void enqueue(int x) {
            // Adds an element x at the rear of the queue.
            Node newNode = new Node(x);
            if (isEmpty()) {
                this.head = newNode;
                this.tail = this.head;
            } else {
                this.tail.next = newNode;
                this.tail = newNode;
            }
            this.count++;
        }

        public void dequeue() {
            // Removes the front element of the queue
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            this.count--;
        }

        public int getFront() {
            // Returns the front element of the queue.
            // If queue is empty, return -1.
            if (isEmpty()) return -1;
            return this.head.data;
        }

        public int size() {
            // Returns the current size of the queue.
            return this.count;
        }
    }

    public static void main(String[] args) {
        myQueue myQueue = new myQueue();
        myQueue.enqueue(5);
        System.out.println(myQueue.getFront());
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.getFront();
        System.out.println(myQueue.getFront());
        myQueue.dequeue();
        System.out.println(myQueue.getFront());
        myQueue.size();
        System.out.println("size: " + myQueue.size());
        myQueue.isEmpty();
        System.out.println("isEmpty: " + myQueue.isEmpty());
    }
}
