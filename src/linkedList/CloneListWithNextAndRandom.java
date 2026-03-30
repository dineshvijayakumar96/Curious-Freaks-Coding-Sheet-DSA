package linkedList;

public class CloneListWithNextAndRandom {

    public static class Node {
        int data;
        Node next;
        Node random;

        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    public static Node clone(Node head) {
        if (head == null) return null;
        //Adding clone node
        Node current = head;
        while (current != null) {
            Node cloneNode = new Node(current.data);
            cloneNode.next = current.next;
            current.next = cloneNode;
            current = cloneNode.next;
        }
        //Cloning random to clone node
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        //Separate clone node from head node
        current = head;
        Node dummy = new Node(0);
        Node cloneTail = dummy;
        while (current != null) {
            cloneTail.next = current.next;
            cloneTail = cloneTail.next;
            current.next = current.next.next;
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(9);
        head.random = head.next.next;
        head.next.random = head.next.next;
        head.next.next.random = null;
        head.next.next.next.random = head.next.next;
        head = clone(head);
        while (head != null) {
            System.out.print(head.data + " ");
            System.out.print("Random: " + (head.random == null ? null : head.random.data));
            head = head.next;
            if (head != null) {
                System.out.print(" -> ");
            }
        }
    }
}
