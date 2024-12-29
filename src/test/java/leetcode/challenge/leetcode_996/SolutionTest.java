package leetcode.challenge.leetcode_996;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 17, 8};
        assert solution.numSquarefulPerms(nums) == 2;
    }
}