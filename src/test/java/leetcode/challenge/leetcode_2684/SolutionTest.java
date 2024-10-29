package leetcode.challenge.leetcode_2684;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test1() {
        assertTrue(Solution.isValidCell(0, 0, 1, 1));
    }


    @Test
    void test2() {
        assertFalse(Solution.isValidCell(1, 1, 1, 1));
    }

    @Test
    void test3() {
        assertFalse(Solution.isValidCell(0, 1, 1, 1));
    }

    @Test
    void test4() {
        assertFalse(Solution.isValidCell(1, 0, 1, 1));
    }

    @Test
    void test5() {
        int[][] grid = new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        assertEquals(3, solution.maxMoves(grid));
    }


    @Test
    void test6() {
        int[][] grid = new int[][]{{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
        assertEquals(0, solution.maxMoves(grid));
    }
}