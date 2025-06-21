package leetcode.challenge.leetcode_3443;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void given_NWSE_when_countUniqueDirections_then_return_3() {
        String s = "NWSE";
        int k = 1;
        int result = solution.maxDistance(s, k);
        int expected = 3;

        assertEquals(expected, result);
    }
}