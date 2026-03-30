package linkedList;

import java.util.ArrayList;

public class PairSumInDoublyLinkedList {

    public static class Node {
        int data;
        Node next,prev;

        Node(int x){
            data = x;
            next = null;
            prev = null;
        }
    }

    public static ArrayList<ArrayList<Integer>> findPairSum(Node head, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head == null) return res;
        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }
        while (left != null && right != null && left != right && left.prev != right) {
            if (left.data + right.data == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(left.data);
                list.add(right.data);
                res.add(list);
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(9);
        head.prev = null;
        head.next.prev = head;
        head.next.next.prev = head.next;
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        int target = 7;
        System.out.println("Output: " + findPairSum(head, target));
    }
}
