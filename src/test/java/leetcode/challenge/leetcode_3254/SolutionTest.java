package leetcode.challenge.leetcode_3254;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[] {1, 2, 3, 4, 3, 2, 5};
        int k = 3;
        int[] expected = new int[] {3, 4, -1, -1, -1};
        int[] actual = solution.resultsArray(nums, k);
        assertArrayEquals(expected, actual);
    }
}
