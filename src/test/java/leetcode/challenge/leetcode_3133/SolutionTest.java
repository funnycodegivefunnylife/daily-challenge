package leetcode.challenge.leetcode_3133;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int n = 3;
        int x = 4;
        long expected = 6;
        long actual = solution.minEnd(n, x);
        assertEquals(expected, actual);
    }

    // Input: n = 2, x = 7
    //
    // Output: 15

    @Test
    void test2() {
        int n = 2;
        int x = 7;
        long expected = 15;
        long actual = solution.minEnd(n, x);
        assertEquals(expected, actual);
    }

    // 6715154
    // x =
    // 7193485

    @Test
    void test3() {
        int n = 6715154;
        int x = 7193485;
        long expected = 55012476815L;
        long actual = solution.minEnd(n, x);
        assertEquals(expected, actual);
    }

    // 2
    // x =
    // 4

    @Test
    void test4() {
        int n = 2;
        int x = 4;
        long expected = 5;
        long actual = solution.minEnd(n, x);
        assertEquals(expected, actual);
    }
}
