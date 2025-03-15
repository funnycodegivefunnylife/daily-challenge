package leetcode.challenge.leetcode_2560;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int size = 1;
        int k = 1;

        boolean actual = solution.isValidSizeToPickK(size, k);

        assertTrue(actual);
    }

    @Test
    public void test2() {
        int size = 1;
        int k = 2;

        boolean actual = solution.isValidSizeToPickK(size, k);

        assertFalse(actual);
    }

    @Test
    public void test3() {
        int size = 2;
        int k = 2;

        boolean actual = solution.isValidSizeToPickK(size, k);

        assertFalse(actual);
    }

    //nums =
    //[2,3,5,9]
    //k =
    //2
    //Output 5

    @Test
    public void test4() {
        int[] nums = new int[]{2, 3, 5, 9};
        int k = 2;
        int actual = solution.minCapability(nums, k);
        int expected = 5;

        assertEquals(expected, actual);
    }

    //[2,7,9,3,1]
    //k =
    //2

    @Test
    public void test5() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int k = 2;
        int actual = solution.minCapability(nums, k);
        int expected = 2;

        assertEquals(expected, actual);
    }
}