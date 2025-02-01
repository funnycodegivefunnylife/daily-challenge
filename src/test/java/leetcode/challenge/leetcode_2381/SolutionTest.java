package leetcode.challenge.leetcode_2381;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    @DisplayName("Given character a, shift by 3, should return d")
    public void test1() {
        char c = 'a';
        int shift = 3;
        boolean shiftRight = true;
        char actual = solution.applyShift(c, shift, shiftRight);

        assert 'd' == actual;
    }

    @Test
    @DisplayName("Given character z, shift by 3, should return c")
    public void test2() {
        char c = 'z';
        int shift = 3;
        boolean shiftRight = true;
        char actual = solution.applyShift(c, shift, shiftRight);

        assert 'c' == actual;
    }

    @Test
    @DisplayName("Given character a, shift by 3, shift left, should return x")
    public void test3() {
        char c = 'a';
        int shift = 3;
        boolean shiftRight = false;
        char actual = solution.applyShift(c, shift, shiftRight);

        assert 'x' == actual;
    }

    // s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
    // Output: "ace"

    @Test
    @DisplayName("Given string abc, shifts = [[0,1,0],[1,2,1],[0,2,1]], should return ace")
    public void test4() {
        String s = "abc";
        int[][] shifts = new int[][] {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        String actual = solution.shiftingLetters(s, shifts);
        String expected = "ace";

        assert expected.equals(actual);
    }
}
