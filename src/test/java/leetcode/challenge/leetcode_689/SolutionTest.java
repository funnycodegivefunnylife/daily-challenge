package leetcode.challenge.leetcode_689;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    // [1,2,1,2,6,7,5,1]
    // k =
    // 2
    // Output
    // [3,4,5]
    // Expected
    // [0,3,5]

    @Test
    public void test1() {
        int[] nums = new int[] {1, 2, 3, 4};
        int k = 1;
        int[] actual = solution.maxSumOfThreeSubarrays(nums, k);
        int[] expected = new int[] {1, 2, 3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 2;
        int[] actual = solution.maxSumOfThreeSubarrays(nums, k);
        int[] expected = new int[] {2, 4, 6};

        assertArrayEquals(expected, actual);
    }
}
