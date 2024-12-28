package leetcode.challenge.leetcode_2554;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    //banned =
    //[1,2,3,4,5,6,7]
    //n =
    //8
    //maxSum =
    //1

    @Test
    public void test1() {
        int[] banned = new int[] {1, 2, 3, 4, 5, 6, 7};
        int n = 8;
        int maxSum = 1;

        int actual = solution.maxCount(banned, n, maxSum);

        assertEquals(0, actual);
    }

//    /banned =
//[1,6,5]
//n =
//5
//maxSum =
//6

    @Test
    public void test2() {
        int[] banned = new int[] {1, 6, 5};
        int n = 5;
        int maxSum = 6;

        int actual = solution.maxCount(banned, n, maxSum);

        assertEquals(2, actual);
    }

    //banned =
    //[1,2,3,4,5,6,7]
    //n =
    //8
    //maxSum =
    //1

    @Test
    public void test3() {
        int[] banned = new int[] {1, 2, 3, 4, 5, 6, 7};
        int n = 8;
        int maxSum = 1;

        int actual = solution.maxCount(banned, n, maxSum);

        assertEquals(0, actual);
    }

    //banned =
    //[1,6,5]
    //n =
    //5
    //maxSum =
    //6

    @Test
    public void test4() {
        int[] banned = new int[] {1, 6, 5};
        int n = 5;
        int maxSum = 6;

        int actual = solution.maxCount(banned, n, maxSum);

        assertEquals(2, actual);
    }

    //banned =
    //[1,2,3,4,5,6,7]
    //n =
    //8
    //maxSum =
    //1

    @Test
    public void test5() {
        int[] banned = new int[] {1, 2, 3, 4, 5, 6, 7};
        int n = 8;
        int maxSum = 1;

        int actual = solution.maxCount(banned, n, maxSum);

        assertEquals(0, actual);
    }

    //banned =
    //[1,6,5]
    //n =
    //5
    //maxSum =
    //6

    @Test
    public void test6() {
        int[] banned = new int[] {1, 6, 5};
        int n = 5;
        int maxSum = 6;

        int actual = solution.maxCount(banned, n, maxSum);

        assertEquals(2, actual);
    }
}