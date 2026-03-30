package linkedList;

public class AddNumberLinkedLists {

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node addNumber(Node head1, Node head2) {
        head1 = stripLeadingZero(head1);
        head2 = stripLeadingZero(head2);
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry > 0) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            current.next = new Node(sum % 10);
            current = current.next;
            carry = sum / 10;
        }
        return reverse(dummy.next);
    }

    private static Node stripLeadingZero(Node head) {
        while (head != null && head.next != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head1 = new Node(0);
        head1.next = new Node(0);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(3);
        Node head2 = new Node(0);
        head2.next = new Node(7);
        Node head = addNumber(head1, head2);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
