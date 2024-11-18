package leetcode.challenge.leetcode_2070;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    //Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
    //Output: [2,4,5,5,6,6]

    @Test
    void test1() {
        int[][] items = new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = new int[]{1,2,3,4,5,6};
        int[] expected = new int[]{2,4,5,5,6,6};
        int[] actual = solution.maximumBeauty(items, queries);
        assertArrayEquals(expected, actual);
    }

    //[[10,1000]]
    //[5]
    @Test
    void test2() {
        int[][] items = new int[][]{{10,1000}};
        int[] queries = new int[]{5};
        int[] expected = new int[]{0};
        int[] actual = solution.maximumBeauty(items, queries);
        assertArrayEquals(expected, actual);
    }
}