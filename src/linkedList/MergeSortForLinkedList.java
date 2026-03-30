package linkedList;

public class MergeSortForLinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node middle = findMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    public static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node head = dummy;
        while (left != null && right != null) {
            if (left.data < right.data) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(40);
        head.next = new Node(20);
        head.next.next = new Node(60);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(30);
        Node sorted = mergeSort(head);
        while (sorted != null) {
            System.out.print(sorted.data + " ");
            sorted = sorted.next;
        }
    }
}
