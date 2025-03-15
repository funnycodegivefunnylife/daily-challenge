package leetcode.challenge.leetcode_1780;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int n = 27;
        boolean actual = solution.checkPowersOfThree(n);

        assertEquals(true, actual);
    }
}
