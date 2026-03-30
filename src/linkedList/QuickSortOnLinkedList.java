package linkedList;

public class QuickSortOnLinkedList {

    public static class Node {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    public static Node quickSort(Node head) {
        if (head == null || head.next == null) return head;
        //Heads
        Node lessDummy = new Node(0);
        Node middleDummy = new Node(0);
        Node greaterDummy = new Node(0);
        //Tails
        Node lessTail = lessDummy;
        Node middleTail = middleDummy;
        Node greaterTail = greaterDummy;
        //Pivot
        int pivotValue = head.data;
        Node current = head;
        while (current != null) {
            if (current.data < pivotValue) {
                lessTail.next = current;
                lessTail = lessTail.next;
            } else if (current.data == pivotValue) {
                middleTail.next = current;
                middleTail = middleTail.next;
            } else {
                greaterTail.next = current;
                greaterTail = greaterTail.next;
            }
            current = current.next;
        }
        //Add Break Point
        lessTail.next = null;
        middleTail.next = null;
        greaterTail.next = null;
        //Recursion Starts
        Node sortedLess = quickSort(lessDummy.next);
        Node sortedGreater = quickSort(greaterDummy.next);
        //Connect Together
        Node newHead;
        if (sortedLess != null) {
            newHead = sortedLess;
            Node tailOfLess = getTail(sortedLess);
            tailOfLess.next = middleDummy.next;
        } else {
            newHead = middleDummy.next;
        }
        middleTail.next = sortedGreater;
        return newHead;
    }

    public static Node getTail(Node head) {
        if (head == null) return head;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(3);
        head.next.next.next = new Node(8);
        Node sorted = quickSort(head);
        while (sorted != null) {
            System.out.print(sorted.data + " ");
            sorted = sorted.next;
        }
    }
}
