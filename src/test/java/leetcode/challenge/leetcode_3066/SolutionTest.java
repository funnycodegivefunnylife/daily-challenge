package leetcode.challenge.leetcode_3066;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    //Input: nums = [1,1,2,4,9], k = 20
    //Output: 4

    @Test
    public void test1() {
        int[] nums = new int[] {1, 1, 2, 4, 9};
        int k = 20;
        int actual = solution.minOperations(nums, k);
        int expected = 4;

        assertEquals(expected, actual);
    }
}