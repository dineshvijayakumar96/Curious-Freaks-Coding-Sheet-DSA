package linkedList;

public class SegregateEvensAndOddsInALinkedList {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node rearrangeEvenOdd(Node head) {
        if (head == null) return null;
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }
        if (oddStart == null || evenStart == null) return head;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);
        head = rearrangeEvenOdd(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
