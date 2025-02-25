package leetcode.challenge.leetcode_2529;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();



    @Test
    public void test1() {
        int[] nums = new int[] {-2, -1, -1, 1, 2, 3};
        int actual = solution.maximumCount(nums);
        int expected = 3;

        assertEquals(expected, actual);
    }

    //[-3,-2,-1,0,0,1,2]

    @Test
    public void test2() {
        int[] nums = new int[] {-3, -2, -1, 0, 0, 1, 2};
        int actual = solution.maximumCount(nums);
        int expected = 3;

        assertEquals(expected, actual);
    }

    //[5,20,66,1314]

    @Test
    public void test3() {
        int[] nums = new int[] {5, 20, 66, 1314};
        int actual = solution.maximumCount(nums);
        int expected = 4;

        assertEquals(expected, actual);
    }
}