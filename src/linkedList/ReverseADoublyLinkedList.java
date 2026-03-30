package linkedList;

public class ReverseADoublyLinkedList {

    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node reverse(Node head) {
        if (head == null) return null;
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            prev.prev = next;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.prev = null;
        head.next = new Node(4);
        head.next.prev = head;
        head.next.next = new Node(5);
        head.next.next.prev = head.next;
        head = reverse(head);
        while (head != null) {
            System.out.print("Previous:" + (head.prev == null ? null : head.prev.data));
            System.out.print(" " + head.data + " ");
            System.out.print(" -> ");
            head = head.next;
        }
    }
}
