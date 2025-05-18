package leetcode.challenge.leetcode_1931;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void givenM1N1_whenColorTheGrid_thenReturn1() {
        int m = 1;
        int n = 1;
        int result = solution.colorTheGrid(m, n);
        int expected = 3;

        assertEquals(expected, result);
    }

    @Test
    void givenM1N2_whenColorTheGrid_thenReturn6() {
        int m = 1;
        int n = 2;
        int result = solution.colorTheGrid(m, n);
        int expected = 6;

        assertEquals(expected, result);
    }
}