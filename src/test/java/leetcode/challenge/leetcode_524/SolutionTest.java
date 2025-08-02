package leetcode.challenge.leetcode_524;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem 524
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test1() {
        // Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
        // Output: "apple"
        String s = "abpcplea";
        List<String> dictionary = List.of("ale", "apple", "monkey", "plea");
        String expected = "apple";

        String actual = solution.findLongestWord(s, dictionary);

        assertEquals(expected, actual);
    }
}
