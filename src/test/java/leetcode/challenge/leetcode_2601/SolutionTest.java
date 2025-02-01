package leetcode.challenge.leetcode_2601;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // [4,9,6,10]

    @Test
    void test1() {
        int[] arr = new int[] {4, 9, 6, 10};
        boolean expected = true;
        boolean actual = solution.primeSubOperation(arr);
        assertEquals(expected, actual);
    }

    //    [3,4,10,15,6]/
    @Test
    void test2() {
        int[] arr = new int[] {3, 4, 10, 15, 6};
        boolean expected = true;
        boolean actual = solution.primeSubOperation(arr);
        assertEquals(expected, actual);
    }
}
