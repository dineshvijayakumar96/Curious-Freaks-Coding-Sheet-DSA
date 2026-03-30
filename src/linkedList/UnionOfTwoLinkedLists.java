package linkedList;

import java.util.TreeSet;

public class UnionOfTwoLinkedLists {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node unionList(Node head1, Node head2) {
        TreeSet<Integer> set = new TreeSet<>();
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null) {
            set.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            set.add(temp2.data);
            temp2 = temp2.next;
        }
        Node dummy = new Node(0);
        Node temp = dummy;
        for (int value : set) {
            temp.next = new Node(value);
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(6);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(3);
        head1.next.next.next.next.next = new Node(8);
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(2);
        Node union = unionList(head1, head2);
        while (union != null) {
            System.out.print(union.data + " ");
            union = union.next;
        }
    }
}
