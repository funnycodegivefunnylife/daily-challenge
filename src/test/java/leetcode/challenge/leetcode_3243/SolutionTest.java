package leetcode.challenge.leetcode_3243;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int n = 5;
        int[][] queries = new int[][] {{2, 4}, {0, 2}, {0, 4}};
        int[] expected = new int[] {3, 2, 1};
        int[] actual = solution.shortestDistanceAfterQueries(n, queries);
        assertArrayEquals(expected, actual);
    }
}
