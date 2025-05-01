package leetcode.challenge.leetcode_2962;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void countSubarrays() {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        long result = solution.countSubarrays(nums, k);
        long expected = 6L;

        assertEquals(expected, result);
    }
}
