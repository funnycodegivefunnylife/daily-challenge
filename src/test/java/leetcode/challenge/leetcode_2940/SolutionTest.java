package leetcode.challenge.leetcode_2940;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    // heights =
    // [6,4,8,5,2,7]
    // queries =
    // [[0,1],[0,3],[2,4],[3,4],[2,2]]
    // Output
    // [2,4,5,5,2]
    // Expected
    // [2,5,-1,5,2]

    @Test
    public void test1() {
        int[] heights = new int[] {6, 4, 8, 5, 2, 7};
        int[][] queries = new int[][] {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        int[] actual = solution.leftmostBuildingQueries(heights, queries);
        int[] expected = new int[] {2, 5, -1, 5, 2};

        assertArrayEquals(expected, actual);
    }

    // Input: heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
    // Output: [7,6,-1,4,6]

    @Test
    public void test2() {
        int[] heights = new int[] {5, 3, 8, 2, 6, 1, 4, 6};
        int[][] queries = new int[][] {{0, 7}, {3, 5}, {5, 2}, {3, 0}, {1, 6}};
        int[] actual = solution.leftmostBuildingQueries(heights, queries);
        int[] expected = new int[] {7, 6, -1, 4, 6};

        assertArrayEquals(expected, actual);
    }
}
