package leetcode.challenge.leetcode_898;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test7() {
        int[] arr = new int[] {0};
        int expected = 1;
        int actual = solution.subarrayBitwiseORs(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test1() {
        int[] arr = new int[] {0};
        int expected = 1;
        int actual = solution.subarrayBitwiseORs(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] arr = new int[] {1, 1, 2};
        int expected = 3;
        int actual = solution.subarrayBitwiseORs(arr);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] arr = new int[] {1, 2, 4};
        int expected = 6;
        int actual = solution.subarrayBitwiseORs(arr);
        assertEquals(expected, actual);
    }

    // calculateNBit
    @Test
    void test4() {
        int n = 1;
        int expected = 1;
        int actual = solution.calculateNBit(n);
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int n = 2;
        int expected = 2;
        int actual = solution.calculateNBit(n);
        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        int n = 3;
        int expected = 2;
        int actual = solution.calculateNBit(n);
        assertEquals(expected, actual);
    }
}
