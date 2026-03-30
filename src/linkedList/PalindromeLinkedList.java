package linkedList;

public class PalindromeLinkedList {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node reverse(Node head) {
        Node temp =  head, prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        //Middle Pointer
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //
        Node reversed = reverse(slow.next);
        Node temp = head;
        while (reversed != null) {
            if (temp.data != reversed.data) return false;
            else {
                temp = temp.next;
                reversed = reversed.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        System.out.println("Output: " + isPalindrome(head));
    }
}
