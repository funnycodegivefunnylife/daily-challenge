package leetcode.challenge.leetcode_2762;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        // nums = [5,4,2,4]
        // Output: 8

        int[] nums = new int[] {5, 4, 2, 4};
        long expected = 8;

        long actual = solution.continuousSubarrays(nums);

        assertEquals(expected, actual);
    }
}
