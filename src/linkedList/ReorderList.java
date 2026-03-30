package linkedList;

public class ReorderList {

    public static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node reorder(Node head) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverse(secondHalf);
        Node firstHalf = head;
        while (secondHalf != null) {
            Node nextFirst = firstHalf.next;
            Node nextSecond = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = nextFirst;
            firstHalf = nextFirst;
            secondHalf = nextSecond;
        }
        return head;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head = reorder(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
