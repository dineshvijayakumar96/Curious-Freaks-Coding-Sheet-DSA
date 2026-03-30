package linkedList;

public class SearchInLinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int d)  { data = d;  next = null; }
    }

    public static boolean isKeyPresent(Node head, int key){
        if (head == null) return false;
        Node temp = head;
        while (temp != null){
            if (temp.data == key) return true;
            else temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int key = 3;
        System.out.println("Output: " + isKeyPresent(head, key));
    }
}
