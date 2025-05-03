package leetcode.challenge.leetcode_838;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    //"RR.L"

    @Test
    void pushDominoes() {
        String dominoes = "RR.L";
        String result = solution.pushDominoes(dominoes);
        String expected = "RR.L";

        assertEquals(expected, result);
    }

    //".L.R...LR..L.."
    @Test
    void pushDominoes2() {
        String dominoes = ".L.R...LR..L..";
        String result = solution.pushDominoes(dominoes);
        String expected = "LL.RR.LLRRLL..";

        assertEquals(expected, result);
    }
}