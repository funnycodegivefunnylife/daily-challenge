package leetcode.challenge.leetcode_2131;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    @DisplayName("Given [\"lc\",\"cl\",\"gg\"] should return 6")
    public void test1() {
        String[] words = {"lc", "cl", "gg"};
        int result = solution.longestPalindrome(words);
        int expected = 6;

        assertEquals(expected, result);
    }
}