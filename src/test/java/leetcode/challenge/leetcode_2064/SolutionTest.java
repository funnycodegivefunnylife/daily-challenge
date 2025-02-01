package leetcode.challenge.leetcode_2064;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int n = 6;
        int[] quantities = new int[] {11, 6};
        int expected = 3;
        int actual = solution.minimizedMaximum(n, quantities);
        assertEquals(expected, actual);
    }

    // n =
    // 1
    // quantities =
    // [100000]
    @Test
    public void test2() {
        int n = 1;
        int[] quantities = new int[] {100000};
        int expected = 100000;
        int actual = solution.minimizedMaximum(n, quantities);
        assertEquals(expected, actual);
    }
}
