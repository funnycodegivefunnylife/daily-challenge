package leetcode.challenge.leetcode_3306;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    //"ieaouqqieaouqq"

    @Test
    public void test1() {
        String s = "ieaouqqieaouqq";
        long actual = solution.countOfSubstrings(s, 1);
        long expected = 3;

        assertEquals(expected, actual);
    }
}