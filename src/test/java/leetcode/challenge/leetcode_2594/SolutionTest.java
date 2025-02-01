package leetcode.challenge.leetcode_2594;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        // Input: ranks = [4,2,3,1], cars = 10
        // Output: 16

        int[] ranks = new int[] {4, 2, 3, 1};
        int cars = 10;

        long expected = 16;
        long actual = solution.repairCars(ranks, cars);

        assert expected == actual;
    }
}
