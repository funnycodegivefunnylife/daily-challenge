package leetcode.challenge.leetcode_862;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[] {84, -37, 32, 40, 95};
        int k = 167;
        int expected = 3;
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual);
    }

    // [27,20,79,87,-36,78,76,72,50,-26]
    // k = 453
    @Test
    void test2() {
        int[] nums = new int[] {27, 20, 79, 87, -36, 78, 76, 72, 50, -26};
        int k = 453;
        int expected = 9;
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual);
    }

    // Input: nums = [1], k = 1
    // Output: 1

    @Test
    void test3() {
        int[] nums = new int[] {1};
        int k = 1;
        int expected = 1;
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual);
    }

    // [2,-1,2]
    // k = 3

    @Test
    void test4() {
        int[] nums = new int[] {2, -1, 2};
        int k = 3;
        int expected = 3;
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual);
    }

    // public int findNearestLteK(int[] prefixSum, int high, int value) {

    // [-34,37,51,3,-12,-50,51,100]
    // k = 151
    @Test
    void test7() {
        int[] nums = new int[] {-34, 37, 51, 3, -12, -50, 51, 100};
        int k = 151;
        int expected = 2;
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual);
    }

    // [56,-21,56,35,-9]
    // k =
    // 61
    @Test
    void test8() {
        int[] nums = new int[] {56, -21, 56, 35, -9};
        int k = 61;
        int expected = 2;
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual);
    }

    // [44,-25,75,-50,-38,-42,-32,-6,-40,-47]
    // k = 19
    @Test
    void test9() {
        int[] nums = new int[] {44, -25, 75, -50, -38, -42, -32, -6, -40, -47};
        int k = 19;
        int expected = 1;
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual);
    }
}
