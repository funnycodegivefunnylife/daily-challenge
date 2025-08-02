package leetcode.challenge.leetcode_2044;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem 2044
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    // nums =
    // [2,2,2]
    @Test
    void testCountMaxOrSubsets() {
        int[] nums = {2, 2, 2};
        int expected = 7; // All subsets of [2, 2, 2] have OR value of 2
        assertEquals(expected, solution.countMaxOrSubsets(nums));
    }

    // Input: nums = [3,2,1,5]

    @Test
    void testCountMaxOrSubsetsWithDifferentValues() {
        int[] nums = {3, 2, 1, 5};
        int expected = 6; // Subsets with max OR value of 7
        assertEquals(expected, solution.countMaxOrSubsets(nums));
    }
}
