package linkedList;

public class IntersectionInYShapedLists {

    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node findIntersection(Node head1, Node head2) {
        if (head1 == null) return null;
        if (head2 == null) return null;
        Node t1 = head1, t2 = head2;
        while (t1 != t2) {
            if (t1 == null) {
                t1 = head2;
            } else {
                t1 = t1.next;
            }

            if (t2 == null) {
                t2 = head1;
            } else {
                t2 = t2.next;
            }
        }
        return t1;
    }

    public static void main(String[] args) {
        Node intersection = new Node(15);
        intersection.next = new Node(30);

        // 2. Build the first list and attach the intersection
        Node head1 = new Node(10);
        head1.next = intersection; // List 1: 10 -> 15 -> 30

        // 3. Build the second list and attach the same intersection
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
        head2.next.next.next = intersection; // List 2: 3 -> 6 -> 9 -> 15 -> 30

        Node temp = findIntersection(head1, head2);
        System.out.println("Output: " + temp.val);
    }
}
