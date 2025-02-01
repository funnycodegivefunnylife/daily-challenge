package leetcode.challenge.leetcode_2226;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // Input: candies = [5,8,6], k = 3
    // Output: 5
    @Test
    public void test1() {
        int[] candies = new int[] {5, 8, 6};
        long k = 3;

        int actual = solution.maximumCandies(candies, k);

        assert actual == 5;
    }

    // [2,5]
    // k =
    // 11

    @Test
    public void test2() {
        int[] candies = new int[] {2, 5};
        long k = 11;

        int actual = solution.maximumCandies(candies, k);

        assert actual == 0;
    }
}
