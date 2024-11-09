package leetcode.challenge.leetcode_2275;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // [8,8]

    @Test
    void test1() {
        int[] arr = new int[]{8,8};
        int expected = 2;
        int actual = solution.largestCombination(arr);
        assertEquals(expected, actual);
    }
}