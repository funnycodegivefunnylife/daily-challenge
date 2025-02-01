package leetcode.challenge.leetcode_contest_428;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // [3,3,3,1,3]
    // Use Testcase
    // Output
    // 4
    // Expected
    // 3

    @Test
    public void test1() {
        int[] nums = new int[] {3, 3, 3, 1, 3};

        int actual = solution.beautifulSplits(nums);

        assertEquals(3, actual);
    }

    // [3,3,3,1,3]
    // arr1: [3], arr2: [3, 3],
}
