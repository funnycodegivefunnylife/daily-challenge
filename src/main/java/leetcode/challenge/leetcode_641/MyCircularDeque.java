package leetcode.challenge.leetcode_641;

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}

class MyCircularDeque {
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        size++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }

        size--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }

        size--;

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return head.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
