package leetcode.challenge.leetcode_233;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        int n = 13;
        int expected = 6;
        int actual = solution.countDigitOne(n);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int n = 0;
        int expected = 0;
        int actual = solution.countDigitOne(n);
        assertEquals(expected, actual);
    }

}