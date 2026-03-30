package linkedList;

public class SubtractionInLinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

    public static Node subtraction(Node head1, Node head2) {
        int length1 = length(head1);
        int length2 = length(head2);
        Node large = null, small = null;
        if (length1 > length2) {
            large = head1;
            small = head2;
        } else if (length1 < length2) {
            large = head2;
            small = head1;
        } else {
            Node t1 = head1;
            Node t2 = head2;
            while (t1 != null && t2 != null && t1.data == t2.data) {
                t1 = t1.next;
                t2 = t2.next;
            }
            if (t1 == null) {
                return new Node(0);
            }
            if (t1.data > t2.data) {
                large = head1;
                small = head2;
            } else {
                large = head2;
                small = head1;
            }
        }
        large = reverse(large);
        small = reverse(small);

        Node dummy = new Node(0);
        Node current = dummy;
        int borrow = 0;
        while (large != null) {
            int difference = large.data - borrow;
            if (small != null) {
                difference = difference - small.data;
                small = small.next;
            }
            if (difference < 0) {
                difference = difference + 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            current.next = new Node(difference);
            current = current.next;
            large = large.next;
        }
        Node result = reverse(dummy.next);
        return stripLeadingZero(result);
    }

    private static Node stripLeadingZero(Node head) {
        while (head != null && head.next != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    private static int length(Node head) {
        Node current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(0);
        head1.next.next = new Node(0);
        Node head2 = new Node(1);
        head2.next = new Node(2);
        Node head = subtraction(head1, head2);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
