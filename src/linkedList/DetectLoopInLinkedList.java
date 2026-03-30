package linkedList;

public class DetectLoopInLinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static boolean isListInLoop(Node head, int pos) {
        if (head == null) return false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(7);
        head.next.next = new Node(8);
        head.next.next.next = new Node(10);
        head.next.next.next.next = head;
        int pos = 1;
        System.out.println("Output: " + isListInLoop(head, pos));
    }
}
