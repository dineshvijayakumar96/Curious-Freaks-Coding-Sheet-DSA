package linkedList;

public class RemoveLoopInLinkedList {

    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findAndRemoveLoop(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                if (slow == head) {
                    while (fast.next != head) {
                        fast = fast.next;
                    }
                } else {
                    slow = head;
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
                fast.next = null;
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;
        Node result = findAndRemoveLoop(head);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
