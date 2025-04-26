package leetcode.challenge.leetcode_3160;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

   //limit =
    //4
    //queries =
    //[[1,4],[2,5],[1,3],[3,4]]

    @Test
    void queryResults() {
        int limit = 4;
        int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        int[] result = solution.queryResults(limit, queries);
        int[] expected = {1, 2, 2, 3};

        assertArrayEquals(expected, result);
    }
}