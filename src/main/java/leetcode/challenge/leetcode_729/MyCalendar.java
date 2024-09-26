package leetcode.challenge.leetcode_729;

interface Bookable {
    boolean book(int start, int end);
}

class TimeUtil {
    public static boolean isOverlap(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2) || (start2 < end1 && end2 > start1);
    }
}

class Node {
    int start;
    int end;
    Node left;
    Node right;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SegmentTree implements Bookable {
    Node root;
    public SegmentTree() {
        root =  new Node(-1, -1);
    }

    public boolean book(int start, int end) {
        return insert(root, start, end);
    }

    private boolean insert(Node node, int start, int end) {
        if (node == null) {
            node = new Node(start, end);
            return true;
        }
        boolean isOverlap = TimeUtil.isOverlap(start, end, node.start, node.end);
        if (isOverlap) {
            return false;
        }

        if (start >= node.end) {
            if (node.right == null) {
                node.right = new Node(start, end);
                return true;
            } else {
                return insert(node.right, start, end);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(start, end);
                return true;
            } else {
                return insert(node.left, start, end);
            }
        }
    }
}

public class MyCalendar {
    Bookable bookable;
    public MyCalendar() {
        bookable = new SegmentTree();
    }

    public boolean book(int start, int end) {
        return bookable.book(start, end);
    }
}