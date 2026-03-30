package linkedList;

public class FindLengthOfLoop {

    public static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static int lengthOfLoop(Node head) {
        if (head == null) return 0;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return loopLength(slow);
            }
        }
        return 0;
    }

    private static int loopLength(Node loop) {
        Node temp = loop;
        int length = 1;
        while (temp.next != loop) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;
        System.out.println("Output: " + lengthOfLoop(head));
    }
}
