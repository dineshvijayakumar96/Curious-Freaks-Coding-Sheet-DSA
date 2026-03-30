package linkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromALinkedList {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeDuplicates(Node head) {
        if (head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        Node current = head, previous = null;
        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head = removeDuplicates(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
