package linkedList;

public class LongestPalindromeInLinkedList {

    public static class Node {
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public static int longestPalindrome(Node head) {
        if (head == null) return 0;
        Node prev = null;
        Node current = head;
        int maxLength = 1;
        while (current != null) {
            Node next = current.next;
            int oddLength = 2 * countMatching(prev, next) + 1;
            int evenLength = 2 * countMatching(prev, current);
            maxLength = Math.max(maxLength, Math.max(oddLength, evenLength));
            //Update Node
            current.next = prev;
            prev = current;
            current = next;
        }
        return maxLength;
    }

    private static int countMatching(Node a, Node b) {
        int count = 0;
        while (a != null && b != null) {
            if (a.data == b.data) {
                count++;
                a = a.next;
                b = b.next;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(7);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(24);
        System.out.println("Output: " + longestPalindrome(head));
    }
}
