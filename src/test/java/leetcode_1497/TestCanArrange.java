package leetcode_1497;

import leetcode.challenge.leetcode_1497.Solution;
import org.junit.jupiter.api.Test;

public class TestCanArrange {

    private boolean canArrange(int[] arr, int k) {
        Solution solution = new Solution();
        return solution.canArrange(arr, k);
    }

    //[5,5,1,2,3,4], k = 10
    @Test
    public void test1() {
        int[] arr = new int[]{5, 5, 1, 2, 3, 4};
        int k = 10;
        assert !canArrange(arr, k);
    }
}
