package leetcode.challenge.leetcode_684;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // [[1,2],[1,3],[2,3]]

    @Test
    void findRedundantConnection() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] result = solution.findRedundantConnection(edges);
        int[] expected = {2, 3};

        assertArrayEquals(expected, result);
    }
}
