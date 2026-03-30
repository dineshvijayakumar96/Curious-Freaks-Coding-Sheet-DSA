package linkedList;

public class MergeTwoSortedLinkedLists {

    public static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node dummy = new Node(0);
        Node current = dummy;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                current.next = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }
        if (temp1 != null) {
            current.next = temp1;
        }
        if (temp2 != null) {
            current.next = temp2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);
        Node merged = merge(head1, head2);
        while (merged != null) {
            System.out.print(merged.data + " ");
            merged = merged.next;
        }
    }
}
