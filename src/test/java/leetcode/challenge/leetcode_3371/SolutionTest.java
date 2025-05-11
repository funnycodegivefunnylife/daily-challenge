package leetcode.challenge.leetcode_3371;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = {2, 3, 5, 10};
        int result = solution.getLargestOutlier(nums);
        int expected = 10;

        assertEquals(expected, result);
    }
}