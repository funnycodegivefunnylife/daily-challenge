package leetcode.challenge.leetcode_3100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int numBottles = 10;
        int numExchange = 3;
        int actual = solution.maxBottlesDrunk(numBottles, numExchange);

        assert (actual == 13);
    }
}