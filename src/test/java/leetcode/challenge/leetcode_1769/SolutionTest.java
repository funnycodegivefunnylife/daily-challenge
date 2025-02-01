package leetcode.challenge.leetcode_1769;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        String boxes = "110";
        int[] actual = solution.minOperations(boxes);
        int[] expected = new int[] {1, 1, 3};

        assertArrayEquals(expected, actual);
    }
}
