package leetcode.challenge.leetcode_996;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    public void test1() {
        Node node = new Node(1, 2, "1,2");
        assert node.allVisited(1);
    }

    @Test
    public void test2() {
        Node node = new Node(1, 2, "1,2");
        assert !node.contains(2);
    }

    @Test
    public void test3() {
        Node node = new Node(1, 2, "1,2");
        assert node.contains(0);
    }
}