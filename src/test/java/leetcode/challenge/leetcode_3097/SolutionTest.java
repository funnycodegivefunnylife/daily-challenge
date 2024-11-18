package leetcode.challenge.leetcode_3097;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    //Input: nums = [1,2,3], k = 2

    @Test
    void test1() {
        int[] nums = new int[]{1,2,3};
        int k = 2;
        int expected = 1;
        int actual = solution.minimumSubarrayLength(nums, k);
        assertEquals(expected, actual);
    }

    //[2,1,8]
    //k =
    //10

    @Test
    void test2() {
        int[] nums = new int[]{2,1,8};
        int k = 10;
        int expected = 3;
        int actual = solution.minimumSubarrayLength(nums, k);
        assertEquals(expected, actual);
    }
}