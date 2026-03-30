package linkedList;

public class LinkedListGroupReverse {

    public static class Node {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    public static Node reverseByK(Node head, int k) {
        if (head == null || k <= 1) return head;
        Node temp = head, prev = null;
        while (temp != null) {
            Node kThNode = getKthNode(temp, k);
            if (kThNode == null) {
                if (prev != null) {
                    prev.next = reverse(temp);
                } else {
                    head = reverse(temp);
                }
                break;
            }
            Node nextNode = kThNode.next;
            kThNode.next = null;
            reverse(temp);
            if (temp == head) {
                head = kThNode;
            } else {
                prev.next = kThNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }

    public static Node getKthNode(Node head, int k) {
        k--;
        while (head != null && k > 0) {
            k--;
            head = head.next;
        }
        return head;
    }

    public static Node reverse(Node head) {
        Node temp = head,  prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(4);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next.next.next = new Node(6);
        int k = 3;
        Node reversed = reverseByK(head, k);
        while (reversed != null) {
            System.out.print(reversed.data + " ");
            reversed = reversed.next;
        }
    }
}
