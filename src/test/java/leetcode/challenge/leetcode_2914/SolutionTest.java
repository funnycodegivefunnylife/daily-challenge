package leetcode.challenge.leetcode_2914;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        String s = "1001";
        int expected = 2;

        int actual = solution.minChanges(s);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String s = "1110";
        int expected = 1;

        int actual = solution.minChanges(s);

        assertEquals(expected, actual);
    }

    // Input: s = "0000"
    // Output: 0
    @Test
    void test3() {
        String s = "0000";
        int expected = 0;

        int actual = solution.minChanges(s);

        assertEquals(expected, actual);
    }
}
