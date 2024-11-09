package leetcode.challenge.leetcode_3011;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    //Input: nums = [8,4,2,30,15]
    //Output: true

    @Test
    void test1() {
        int[] nums = new int[]{8,4,2,30,15};
        boolean expected = true;
        boolean actual = solution.canSortArray(nums);
        assertEquals(expected, actual);
    }


    //nums =
    //[3,16,8,4,2]

    @Test
    void test2() {
        int[] nums = new int[]{3,16,8,4,2};
        boolean expected = false;
        boolean actual = solution.canSortArray(nums);
        assertEquals(expected, actual);
    }
}