package leetcode.challenge.leetcode_2701;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxTaskAssign() {
        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        int pills = 1;
        int strength = 1;
        int result = solution.maxTaskAssign(tasks, workers, pills, strength);
        int expected = 3;

        assertEquals(expected, result);
    }

    // tasks =
    // [5,9,8,5,9]
    // workers =
    // [1,6,4,2,6]
    // pills =
    // 1
    // strength =
    // 5

    @Test
    void maxTaskAssign2() {
        int[] tasks = {5, 9, 8, 5, 9};
        int[] workers = {1, 6, 4, 2, 6};
        int pills = 1;
        int strength = 5;
        int result = solution.maxTaskAssign(tasks, workers, pills, strength);
        int expected = 3;

        assertEquals(expected, result);
    }
}
