package leetcode.challenge.leetcode_1829;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    //Input: nums = [0,1,1,3], maximumBit = 2
    //Output: [0,3,2,3]

    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[]{0,1,1,3};
        int maximumBit = 2;
        int[] expected = new int[]{0,3,2,3};
        int[] actual = solution.getMaximumXor(nums, maximumBit);
        assertArrayEquals(expected, actual);
    }
}