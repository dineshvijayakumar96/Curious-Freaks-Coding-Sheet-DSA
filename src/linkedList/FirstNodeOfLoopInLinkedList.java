package linkedList;

public class FirstNodeOfLoopInLinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int x)
        {
            data = x;
            next = null;
        }
    }

    public static int findFirstNode(Node head) {
        if (head == null) return -1;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                return firstNode(slow, fast);
            }
        }
        return -1;
    }

    private static int firstNode(Node slow, Node fast) {
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;
        System.out.println("Output: " + findFirstNode(head));
    }
}
