package leetcode.challenge.leetcode_658;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    //arr =
    //[1,1,1,10,10,10]
    //k =
    //1
    //x =
    //9

    @Test
    public void test1() {
        int[] arr = new int[] {1, 1, 1, 10, 10, 10};
        int k = 1;
        int x = 9;

        List<Integer> actual = solution.findClosestElements(arr, k, x);

        List<Integer> expected = List.of(10);

        assertArrayEquals(actual.toArray(), expected.toArray());
    }
    //[1,2,3,4,5]
    //k =
    //4
    //x =
    //3

    @Test
    public void test2() {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> actual = solution.findClosestElements(arr, k, x);

        List<Integer> expected = List.of(1, 2, 3, 4);

        assertArrayEquals(actual.toArray(), expected.toArray());
    }
}