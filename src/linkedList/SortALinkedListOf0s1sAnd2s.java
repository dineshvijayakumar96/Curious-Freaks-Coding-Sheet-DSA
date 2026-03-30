package linkedList;

public class SortALinkedListOf0s1sAnd2s {

    public static class Node {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static Node sortTheList(Node head) {
        if (head == null || head.next == null) return head;
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else if (temp.data == 2) {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        if (oneHead.next != null) {
            zero.next = oneHead.next;
        } else {
            zero.next = twoHead.next;
        }
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);
        head = sortTheList(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
