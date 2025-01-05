package leetcode.challenge.leetcode_1930;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test2() {
        String s = "adc";

        assert 0 == solution.countPalindromicSubsequence(s);
    }

    @Test
    public void test1() {
        String s = "aabca";

        assert 3 == solution.countPalindromicSubsequence(s);
    }

    @Test
    public void test3() {
        String s = "bbcbaba";

        assert 4 == solution.countPalindromicSubsequence(s);
    }
}