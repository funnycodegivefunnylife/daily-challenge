package leetcode.challenge.leetcode_3223;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        //s =
        //"abaacbcbb"
        String s = "abaacbcbb";
        int expected = 5;

        assertEquals(expected, solution.minimumLength(s));
    }
}