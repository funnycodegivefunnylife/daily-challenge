package leetcode.challenge.leetcode_866;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();


    @org.junit.jupiter.api.Test
    void test1() {
        int n = 6;
        int expected = 7;
        int actual = solution.primePalindrome(n);
        assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void test2() {
        int n = 8;
        int expected = 11;
        int actual = solution.primePalindrome(n);
        assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void test3() {
        int n = 13;
        int expected = 101;
        int actual = solution.primePalindrome(n);
        assertEquals(expected, actual);
    }

}