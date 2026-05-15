package zoho_problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            if (map.size() > capacity) {
                Node last = popTail();
                map.remove(last.key);
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node popTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private static void testStandardExample() {
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1);
        System.out.println("put(1, 1)");
        lRUCache.put(2, 2);
        System.out.println("put(2, 2)");
        System.out.println("get(1) -> " + lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println("put(3, 3) - Evicts key 2");
        System.out.println("get(2) -> " + lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println("put(4, 4) - Evicts key 1");
        System.out.println("get(1) -> " + lRUCache.get(1));
        System.out.println("get(3) -> " + lRUCache.get(3));
        System.out.println("get(4) -> " + lRUCache.get(4));
    }

    private static void testCapacityOne() {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println("get(2) -> " + cache.get(2));
        cache.put(3, 2);
        System.out.println("get(2) -> " + cache.get(2));
        System.out.println("get(3) -> " + cache.get(3));
    }

    private static void testUpdateExistingKey() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        System.out.println("put(2, 3) - Updates existing key");
        cache.put(4, 1);
        System.out.println("put(4, 1) - Evicts key 1");
        System.out.println("get(1) -> " + cache.get(1));
        System.out.println("get(2) -> " + cache.get(2));
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        testStandardExample();

        System.out.println("\n--- Test Case 2 ---");
        testCapacityOne();

        System.out.println("\n--- Test Case 3 ---");
        testUpdateExistingKey();
    }
}
