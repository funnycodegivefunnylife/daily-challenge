package leetcode.challenge.leetcode_2869;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        // [3,1,5,4,2]
        // k =
        // 2
        List<Integer> nums = List.of(3, 1, 5, 4, 2);

        int k = 2;

        int actual = solution.minOperations(nums, k);

        int expected = 4;

        assertEquals(expected, actual);
    }

    // nums =
    // [18,31,18,22,14,27,19,28,4,33,33,17,44,16,20,8,40,5,42,4,26,19,23,15,24,32,29,1,2,30,22,46,10,12,6,32,35,13,30,21,46,11,25,7,3,11,34,9,15,28]
    // k =
    // 35

    @Test
    public void test2() {
        List<Integer> nums = List.of(
                18, 31, 18, 22, 14, 27, 19, 28, 4, 33, 33, 17, 44, 16, 20, 8, 40, 5, 42, 4, 26, 19, 23, 15, 24, 32, 29,
                1, 2, 30, 22, 46, 10, 12, 6, 32, 35, 13, 30, 21, 46, 11, 25, 7, 3, 11, 34, 9, 15, 28);

        int k = 35;

        int actual = solution.minOperations(nums, k);

        int expected = 49;

        assertEquals(expected, actual);
    }
}
