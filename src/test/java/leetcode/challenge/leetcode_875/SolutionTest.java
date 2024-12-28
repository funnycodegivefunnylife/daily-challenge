package leetcode.challenge.leetcode_875;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        //Input: piles = [3,6,7,11], H = 8
        //Output: 4

        int[] piles = new int[] {3, 6, 7, 11};
        int H = 8;

        boolean actual = solution.canEatingWithSpeed(piles, H, 3);

        assert !actual;

    }

    //piles =
    //[805306368,805306368,805306368]
    //h =
    //1000000000

    @Test
    public void test2() {
        //Input: piles = [30,11,23,4,20], H = 5
        //Output: 30

        int[] piles = new int[] {805306368, 805306368, 805306368};
        int H = 1000000000;

        boolean actual = solution.canEatingWithSpeed(piles, H, 1);

        assert !actual;

    }
}