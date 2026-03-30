package linkedList;

public class RemoveDuplicatesFromASortedLinkedList {

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
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head = removeDuplicates(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
