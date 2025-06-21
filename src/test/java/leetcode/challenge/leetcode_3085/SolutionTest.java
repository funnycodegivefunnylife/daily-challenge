package leetcode.challenge.leetcode_3085;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem 3085
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testExample1() {
        //Input: word = "aabcaba", k = 0
        //
        //Output: 3

        String word = "aabcaba";
        int k = 0;
        int result = solution.minimumDeletions(word, k);
        int expected = 3;

        assertEquals(expected, result);
    }

    //Input: word = "dabdcbdcdcd", k = 2

    @Test
    void testExample2() {
        String word = "dabdcbdcdcd";
        int k = 2;
        int result = solution.minimumDeletions(word, k);
        int expected = 2;

        assertEquals(expected, result);
    }

    //word =
    //"r"
    //k =
    //0
    //
    //Use Testcase
    //Output
    //1
    //Expected
    //0
    @Test
    void testSingleCharacter() {
        String word = "r";
        int k = 0;
        int result = solution.minimumDeletions(word, k);
        int expected = 0;

        assertEquals(expected, result);
    }

}
