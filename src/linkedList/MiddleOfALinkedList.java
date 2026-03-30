package linkedList;

public class MiddleOfALinkedList {
    public static class Node{
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static int findTheMiddle(Node head){
        if (head == null || head.next == null) return -1;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(2);
        head.next.next.next = new Node(13);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(13);
        head.next.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.next.next = new Node(6);
        System.out.println("Output: " + findTheMiddle(head));
    }
}
