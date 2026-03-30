package linkedList;

public class DeleteNNodesAfterMNodesOfALinkedList {

    public static class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static void deleteNAfterM(Node head, int n, int m) {
        if (head == null || head.next == null) return;
        Node current = head;
        while (current != null) {
            for (int count = 1; count < m && current != null; count++) {
                current = current.next;
            }
            if (current == null) {
                break;
            }
            Node tail =  current.next;
            for (int count = 1; count <= n && tail != null; count++) {
                tail = tail.next;
            }
            current.next = tail;
            current = tail;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next.next = new Node(1);
        int n = 1;
        int m = 2;
        deleteNAfterM(head, n, m);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
