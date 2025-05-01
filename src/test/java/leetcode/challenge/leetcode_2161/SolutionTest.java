package leetcode.challenge.leetcode_2161;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[] {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        int[] actual = solution.pivotArray(nums, pivot);
        int[] expected = new int[] {9, 5, 3, 10, 10, 12, 14};

        assertArrayEquals(expected, actual);
    }
}
