package leetcode.challenge.leetcode_1652;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    //Input: code = [5,7,1,4], k = 3
    //Output: [12,10,16,13]

    @Test
    void test1() {
        int[] code = new int[]{5,7,1,4};
        int k = 3;
        int[] expected = new int[]{12,10,16,13};
        int[] actual = solution.decrypt(code, k);
        assertArrayEquals(expected, actual);
    }


}