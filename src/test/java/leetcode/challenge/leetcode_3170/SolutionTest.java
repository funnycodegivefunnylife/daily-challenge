package leetcode.challenge.leetcode_3170;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();
    // "d*d*"

    @Test
    void clearStars() {
        String s = "d*d*";
        String result = solution.clearStars(s);
        String expected = "";

        assertEquals(expected, result);
    }

    // "s*z*"
    // "s*z*"

    @Test
    void clearStars2() {
        String s = "s*z*";
        String result = solution.clearStars(s);
        String expected = "";

        assertEquals(expected, result);
    }
}
