package leetcode.challenge.leetccode_2593;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[] {2, 1, 3, 4, 5, 2};
        long actual = solution.findScore(nums);
        assertEquals(7, actual);
    }
}
