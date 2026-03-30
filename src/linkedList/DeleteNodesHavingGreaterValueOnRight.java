package linkedList;

public class DeleteNodesHavingGreaterValueOnRight {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node deleteNode(Node head) {
        if (head == null || head.next == null) return head;
        head = reverse(head);
        Node current = head;
        int max = head.data;
        while (current.next != null) {
            if (current.next.data < max) {
                current.next = current.next.next;
            } else {
                current = current.next;
                max = current.data;
            }
        }
        return reverse(head);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);
        head = deleteNode(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
