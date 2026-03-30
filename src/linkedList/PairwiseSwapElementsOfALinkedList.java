package linkedList;

public class PairwiseSwapElementsOfALinkedList {

    public static class Node {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    public static Node pairWiseSwap(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node previous = dummy;
        Node current = head;
        while (current != null && current.next != null) {
            Node first = current;
            Node second = current.next;
            //Swap
            previous.next = second;
            first.next = second.next;
            second.next = first;
            //Update
            previous = first;
            current = first.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head = pairWiseSwap(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
