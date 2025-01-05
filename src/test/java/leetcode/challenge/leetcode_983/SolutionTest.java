package leetcode.challenge.leetcode_983;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    //Input: days = [1,4,6,7,8,20], costs = [2,7,15]
    //Output: 11

    @Test
    public void test1() {
        int[] days = new int[] {1,4,6,7,8,20};
        int[] costs = new int[] {2,7,15};
        int actual = solution.mincostTickets(days, costs);
        int expected = 11;

        assertEquals(expected, actual);
    }

    //[1,4,6,7,8,20]
    //costs =
    //[7,2,15]
    //Output
    //11
    //Expected
    //6

    @Test
    public void test2() {
        int[] days = new int[] {1,4,6,7,8,20};
        int[] costs = new int[] {7,2,15};
        int actual = solution.mincostTickets(days, costs);
        int expected = 6;

        assertEquals(expected, actual);
    }
}