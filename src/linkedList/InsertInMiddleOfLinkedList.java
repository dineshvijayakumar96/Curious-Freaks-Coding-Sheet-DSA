package linkedList;

public class InsertInMiddleOfLinkedList {

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node insertX(Node head, int x) {
        if (head == null) return new Node(x);
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node front = slow.next;
        slow.next = new Node(x);
        slow.next.next = front;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        int x = 3;
        head = insertX(head, x);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
