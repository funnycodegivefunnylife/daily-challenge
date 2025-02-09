package leetcode.challenge.leetcode_718;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums1 = new int[] {1,2,3,2,1};
        int[] nums2 = new int[] {3,2,1,4,7};
        int actual = solution.findLength(nums1, nums2);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums1 = new int[] {70,39,25,40,7};
        int[] nums2 = new int[] {52,20,67,5,31};
        int actual = solution.findLength(nums1, nums2);
        int expected = 0;

        assertEquals(expected, actual);
    }
}