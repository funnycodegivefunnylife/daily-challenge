package leetcode.challenge.leetcode_1752;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // Input: nums = [3,4,5,1,2]
    // Output: true

    @Test
    void check_1() {
        int[] nums = {3, 4, 5, 1, 2};
        boolean result = solution.check(nums);
        assertTrue(result);
    }
}
