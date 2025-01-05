package leetcode.challenge.leetcode_2270;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[] {10,4,-8,7};
        int actual = solution.waysToSplitArray(nums);
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] {2,3,1,0};
        int actual = solution.waysToSplitArray(nums);
        int expected = 2;

        assertEquals(expected, actual);
    }
}