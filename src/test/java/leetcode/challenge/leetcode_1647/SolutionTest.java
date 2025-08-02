package leetcode.challenge.leetcode_1647;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem 1647
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testExample1() {

        String s = "aaabbbcc";
        int result = solution.minDeletions(s);
        int expected = 2;
        assertEquals(expected, result);
    }
}
