package leetcode.challenge.leetcode_2461;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[]{1,5,4,2,9,9,9};
        int k = 3;
        int expected = 15;
        long actual = solution.maximumSubarraySum(nums, k);
        assertEquals(expected, actual);
    }
}