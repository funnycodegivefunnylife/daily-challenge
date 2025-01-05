package leetcode.challenge.leetcode_496;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    //[137,59]
    //nums2 =
    //[137,59,79,236,94,171,141]
    //Output
    //[-1,79]
    //Expected
    //[236,79]

    @Test
    public void test1() {
        int[] nums1 = new int[] {137,59};
        int[] nums2 = new int[] {137,59,79,236,94,171,141};
        int[] actual = solution.nextGreaterElement(nums1, nums2);
        int[] expected = new int[] {236,79};

        assertArrayEquals(expected, actual);
    }
}