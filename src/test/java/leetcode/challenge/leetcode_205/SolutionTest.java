package leetcode.challenge.leetcode_205;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem 205
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Given 'egg' and 'add', should return true")
    void testIsIsomorphicEggAdd() {
        String s = "egg";
        String t = "add";
        assertTrue(solution.isIsomorphic(s, t));
    }

    @Test
    @DisplayName("Given 'foo' and 'bar', should return false")
    void testIsIsomorphicFooBar() {
        String s = "foo";
        String t = "bar";
        assertFalse(solution.isIsomorphic(s, t));
    }
}
