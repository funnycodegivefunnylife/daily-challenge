package leetcode.challenge.leetcode_3113;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void numberOfSubarrays() {
        int[] nums = {1, 4, 3, 3, 2};
        long result = solution.numberOfSubarrays(nums);
        long expected = 6L;

        assertEquals(expected, result);
    }
}
