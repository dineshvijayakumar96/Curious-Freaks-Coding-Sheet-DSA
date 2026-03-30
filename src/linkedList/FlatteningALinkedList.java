package linkedList;

public class FlatteningALinkedList {

    public static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    public static Node flattenList(Node root) {
        if (root == null || root.next == null) return root;
        root.next = flattenList(root.next);
        root = mergeTwoList(root, root.next);
        return root;
    }

    private static Node mergeTwoList(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.bottom = head1;
                head1 = head1.bottom;
            } else {
                current.bottom = head2;
                head2 = head2.bottom;
            }
            current = current.bottom;
        }
        if (head1 != null) {
            current.bottom = head1;
        } else {
            current.bottom = head2;
        }
        return dummy.bottom;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);
        root.next = new Node(10);
        root.next.bottom = new Node(20);
        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);
        root.next.next.next = new Node(28);
        root.next.next.next.bottom = new Node(35);
        root.next.next.next.bottom.bottom = new Node(40);
        root.next.next.next.bottom.bottom.bottom = new Node(45);
        root = flattenList(root);
        while (root != null) {
            System.out.println(root.data);
            root = root.bottom;
        }
    }
}
