package leetcode_1590;

import leetcode.challenge.leetcode_1590.MinSubArrayCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMinSubArrayCalculator {

    @Test
    @DisplayName("Given arr: [1000000000,1000000000,1000000000] and p = 3, the method should return 0")
    public void test1() {
        int[] arr = new int[]{1000000000, 1000000000, 1000000000};
        int p = 3;
        assert MinSubArrayCalculator.minSubarray(arr, p) == 0;
    }
}
