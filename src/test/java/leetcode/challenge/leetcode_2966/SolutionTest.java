package leetcode.challenge.leetcode_2966;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    //[1,3,4,8,7,9,3,5,1]

    @Test
    void divideArray() {
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        int[][] result = solution.divideArray(nums, k);

        //[[1,1,3],[3,4,5],[7,8,9]]
        int[][] expected = {
            {1, 1, 3},
            {3, 4, 5},
            {7, 8, 9}
        };

        assertArrayEquals(expected, result);
    }

}