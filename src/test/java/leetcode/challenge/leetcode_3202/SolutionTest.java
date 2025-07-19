package leetcode.challenge.leetcode_3202;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem 3202
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

   //[1,2,3,4,5]

    @Test
    void testMaximumLength() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int expected = 5;
        assertEquals(expected, solution.maximumLength(nums, k));
    }

}
