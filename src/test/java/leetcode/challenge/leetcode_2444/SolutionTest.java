package leetcode.challenge.leetcode_2444;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    //Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
    //Output: 2

    @Test
    void countSubarrays() {
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        long result = solution.countSubarrays(nums, minK, maxK);
        long expected = 2l;

        assertEquals(expected, result);
    }

    //[1,1,1,1]
    //minK =
    //1
    //maxK =
    //1

    @Test
    void countSubarrays2() {
        int[] nums = {1, 1, 1, 1};
        int minK = 1;
        int maxK = 1;
        long result = solution.countSubarrays(nums, minK, maxK);
        long expected = 10l;

        assertEquals(expected, result);
    }
}