package queue;

import java.util.HashMap;

public class LRUCache {

    public static class Node{
        int key;
        int value;
        Node prev, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private static Node head;
    private static Node tail;
    private static int capacity;
    private static HashMap<Integer, Node> map;

    public LRUCache(int size) {
        capacity = size;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    private static void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    private static void deleteNode(Node deleteNode){
        Node tempPrev = deleteNode.prev;
        Node tempNext = deleteNode.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
    }

    public static int get(int key){
        if (map.containsKey(key)) {
            Node resultNode = map.get(key);
            int answer = resultNode.value;

            map.remove(key);
            deleteNode(resultNode);
            addNode(resultNode);
            map.put(key, resultNode);
            return answer;
        } else {
            return -1;
        }
    }

    public static void put(int key, int value){
        if (map.containsKey(key)) {
            Node resultNode = map.get(key);
            map.remove(key);
            deleteNode(resultNode);
        }
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        map.put(key, head.next);
    }

    public static void main(String[] args) {
        int capacity = 2;
        LRUCache lruCache = new LRUCache(capacity);
        lruCache.put(1, 2);
        int value = lruCache.get(1);
        System.out.println("Value For Key(1): " + value);
    }
}
