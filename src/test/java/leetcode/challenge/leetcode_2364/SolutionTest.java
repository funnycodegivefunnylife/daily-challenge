package leetcode.challenge.leetcode_2364;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        long actual = solution.countBadPairs(nums);
        long expected = 0L;

        assertEquals(expected, actual);
    }
}