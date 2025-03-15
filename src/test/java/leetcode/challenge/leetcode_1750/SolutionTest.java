package leetcode.challenge.leetcode_1750;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    //"cabaabac"

    @Test
    public void test1() {
        String s = "cabaabac";
        int actual = solution.minimumLength(s);
        int expected = 0;

        assertEquals(expected, actual);
    }
}