package leetcode.challenge.leetcode_2825;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();


    @Test
    public void test1() {
        String str1 = "zc";
        String str2 = "ad";

        assert solution.canMakeSubsequence(str1, str2);
    }

    @Test
    public void test2() {
        String str1 = "abc";
        String str2 = "ad";

        assert solution.canMakeSubsequence(str1, str2);
    }
}