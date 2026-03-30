package linkedList;

public class DeleteWithoutHeadPointer {

    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void deleteNode(Node del_node) {
        if (del_node == null) return;
        del_node.val = del_node.next.val;
        del_node.next = del_node.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(4);
        head.next.next.next = new Node(30);
        Node del_node = head.next;
        deleteNode(del_node);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
