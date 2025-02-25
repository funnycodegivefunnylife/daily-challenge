package leetcode.challenge.leetcode_1524;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();


    @Test
    public void test1() {
        int[] arr = new int[] {1, 3, 5};
        int actual = solution.numOfSubarrays(arr);
        int expected = 4;

        assertEquals(expected, actual);
    }
}