package leetcode.challenge.leetcode_146;


import java.util.Map;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


public class LRUCacheLinkedListImpl implements ILRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCacheLinkedListImpl(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new java.util.HashMap<>();
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addFirst(node);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {

        boolean containsKey = map.containsKey(key);

        if (!containsKey && isFull()) {
            removeLast();
        }

        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            removeNode(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
        }
        node.value = value;
        addFirst(node);

    }

    private void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        if (next != null) {
            next.prev = node;
        }
    }

    private void removeLast() {
        Node last = tail.prev;
        if (last != null && last != head) {
            map.remove(last.key);
            removeNode(last);
        }
    }

    private void removeNode(Node last) {
        Node prev = last.prev;
        Node next = last.next;

        if (next != null) {
            next.prev = prev;
        }

        if (prev != null) {
            prev.next = next;
        }
    }

    @Override
    public boolean isFull() {
        return map.size() == capacity;
    }


}