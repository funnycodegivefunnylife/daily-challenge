package leetcode.challenge.leetcode_1432;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void given_1234_when_findMaxNum_then_return_9234() {
        int num = 1234;
        String result = solution.findMaxNum(String.valueOf(num));
        String expected = "9234";

        assertEquals(expected, result);
    }
    // 111
    @Test
    void given_111_when_findMaxNum_then_return_999() {
        int num = 111;
        String result = solution.findMaxNum(String.valueOf(num));
        String expected = "999";

        assertEquals(expected, result);
    }

    @Test
    void given_111_when_findMinNum_then_return_111() {
        int num = 111;
        String result = solution.findMinNum(String.valueOf(num));
        String expected = "111";

        assertEquals(expected, result);
    }

    // 9288
    @Test
    void given_9288_when_findMaxNum_then_return_9988() {
        int num = 9288;
        String result = solution.findMaxNum(String.valueOf(num));
        String expected = "9988";

        assertEquals(expected, result);
    }
}
