package leetcode.challenge.leetcode_1590;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = Arrays.stream(nums).asLongStream().sum();

        int remainder = (int) (totalSum % p);
        if (remainder == 0) {
            return 0;
        }
        int result = nums.length;
        long prefixSum = 0;
        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentRemainder = (int) (prefixSum % p);
            int target = (currentRemainder - remainder + p) % p;

            if (prefixSumToIndex.containsKey(target)) {
                result = Math.min(result, i - prefixSumToIndex.get(target));
            }

            prefixSumToIndex.put(currentRemainder, i);
        }

        return result == nums.length ? -1 : result;
    }
}
