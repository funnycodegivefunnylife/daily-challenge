package leetcode.challenge.leetcode_2294;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int nums[] = new int[] {3, 6, 1, 2, 5};

        assert solution.partitionArray(nums, 2) == 2;
    }
}
