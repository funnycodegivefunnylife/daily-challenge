package leetcode.challenge.leetcode_2054;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int[][] events = new int[][] {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};

        int actual = solution.maxTwoEvents(events);

        assertEquals(4, actual);
    }

    @Test
    public void test2() {
        int[][] events = new int[][] {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};

        int actual = solution.maxTwoEvents(events);

        assertEquals(5, actual);
    }
}