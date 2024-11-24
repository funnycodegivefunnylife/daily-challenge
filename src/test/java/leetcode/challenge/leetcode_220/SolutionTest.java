package leetcode.challenge.leetcode_220;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();


    @Test
    void test1() {
        int[] nums = new int[]{1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;
        boolean expected = true;
        boolean actual = solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        assertEquals(expected, actual);
    }


    @Test
    void test2() {
        int[] nums = new int[]{1, 5, 9, 1, 5, 9};
        int indexDiff = 2;
        int valueDiff = 3;
        boolean expected = false;
        boolean actual = solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        assertEquals(expected, actual);
    }
}