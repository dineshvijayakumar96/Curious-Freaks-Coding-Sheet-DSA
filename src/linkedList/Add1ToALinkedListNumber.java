package linkedList;

public class Add1ToALinkedListNumber {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node add1ToLL(Node head) {
        if (head == null) return null;
        Node reversed = reverse(head);
        Node current = reversed;
        int carry = 1;
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;
                break;
            }
            current = current.next;
        }
        return reverse(reversed);
    }

    public static Node reverse(Node head) {
        Node current = head, previous = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head = add1ToLL(head);
        System.out.println("Output: ");
        printLL(head);
    }
}
