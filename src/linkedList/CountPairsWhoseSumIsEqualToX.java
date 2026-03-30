package linkedList;

import java.util.HashSet;

public class CountPairsWhoseSumIsEqualToX {

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int findThePairs(Node head1, Node head2, int x) {
        HashSet<Integer> set = new HashSet<>();
        Node temp1 = head1;
        Node temp2 = head2;
        int count = 0;
        while (temp1 != null) {
            set.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            int difference = x - temp2.data;
            if (set.contains(difference)) {
                count++;
            }
            temp2 = temp2.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        Node head2 = new Node(11);
        head2.next = new Node(12);
        head2.next.next = new Node(13);
        int x = 15;
        System.out.println("Output: " + findThePairs(head1, head2, x));
    }
}
