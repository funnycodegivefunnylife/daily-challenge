package leetcode.challenge.leetcode_2290;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int[][] grid = new int[][] {{0, 1, 1, 1, 0}};
        int expected = 3;
        int actual = solution.minimumObstacles(grid);
        assertEquals(expected, actual);
    }
}
