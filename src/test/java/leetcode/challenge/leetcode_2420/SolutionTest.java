package leetcode.challenge.leetcode_2420;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void countSubarrays() {
        int[] nums = {2, 1, 1, 1, 3, 4, 1};
        int k = 2;

        List<Integer> result = solution.goodIndices(nums, k);

        List<Integer> expected = List.of(2, 3);

        assertEquals(expected.size(), result.size());

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }
}
