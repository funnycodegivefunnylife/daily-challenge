package leetcode.challenge.leetcode_2302;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void countSubarrays() {
        int[] nums = {2, 1, 4, 3, 5};
        int k = 10;
        long result = solution.countSubarrays(nums, k);
        long expected = 6L;

        assertEquals(expected, result);
    }
}