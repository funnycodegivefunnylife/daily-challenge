package leetcode.challenge.leetcode_2981;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        String s = "aaaa";

        int actual = solution.maximumLength(s);

        assert actual == 2;
    }
}
