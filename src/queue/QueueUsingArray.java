package queue;

public class QueueUsingArray {

    public static class myQueue {
        private int[] data;
        private int front;
        private int rear;
        private int count;
        private int capacity;

        // Constructor
        public myQueue(int n) {
            // Define Data Structures
            this.data = new int[n];
            this.front = 0;
            this.rear = -1;
            this.count = 0;
            this.capacity = n;
        }

        public boolean isEmpty() {
            // Check if queue is empty
            return count == 0;
        }

        public boolean isFull() {
            // Check if queue is full
            return count == capacity;
        }

        public void enqueue(int x) {
            // Enqueue
            if (isFull())  {
                System.out.println("Queue is full");
                return;
            }
            rear = (rear + 1) % capacity;
            data[rear] = x;
            count++;
        }

        public void dequeue() {
            // Dequeue
            if (isEmpty())  {
                System.out.println("Queue is empty");
            }
            front = (front + 1) % capacity;
            count--;
        }

        public int getFront() {
            // Get front element
            if (isEmpty())  return -1;
            return data[front];
        }

        public int getRear() {
            // Get last element
            if (isEmpty())  return -1;
            return data[rear];
        }
    }

    public static void main(String[] args) {
        myQueue myQueue = new myQueue(5);
        myQueue.enqueue(5);
        System.out.println(myQueue.getFront());
        myQueue.enqueue(3);
        System.out.println(myQueue.getRear());
        myQueue.enqueue(4);
        System.out.println(myQueue.getRear());
        myQueue.getFront();
        System.out.println(myQueue.getFront());
        myQueue.dequeue();
        System.out.println(myQueue.getFront());
        myQueue.isEmpty();
        System.out.println("isEmpty: " + myQueue.isEmpty());
        myQueue.getRear();
        System.out.println(myQueue.getRear());
    }
}
