package leetcode.challenge.leetcode_72;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    @DisplayName("Given string : horse, ros, Output: 3")
    public void test1() {
        String word1 = "horse";
        String word2 = "ros";
        int actual = solution.minDistance(word1, word2);
        int expected = 3;

        assertEquals(expected, actual);
    }
}