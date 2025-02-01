package leetcode.challenge.leetcode_2563;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[] {0, 1, 7, 4, 4, 5};
        int lower = 3;
        int upper = 6;
        long expected = 6;
        long actual = solution.countFairPairs(nums, lower, upper);
        assertEquals(expected, actual);
    }

    // searchFirstLessThanFromBeginning
    @Test
    void test2() {
        int[] nums = new int[] {0, 1, 7, 4, 4, 5};
        int target = 3;
        int expected = 1;
        int actual = solution.searchFirstLessThanFromBeginning(nums, 0, nums.length - 1, target);
        assertEquals(expected, actual);
    }
}
