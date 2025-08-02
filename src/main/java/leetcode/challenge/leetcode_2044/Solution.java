package leetcode.challenge.leetcode_2044;

import java.util.Arrays;
import java.util.Map;

class Solution {

    public int countMaxOrSubsets(int[] nums) {

        int maxOr = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        Map<Integer, Integer> freqMap = new java.util.HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);
        Map<Integer, Integer> pickElments = new java.util.HashMap<>();
        int currentOr = 0;

        for (int i = nums.length - 1; i >= 0 && currentOr != maxOr; i--) {
            int newOr = currentOr | nums[i];
            if (newOr != currentOr) {
                currentOr = newOr;
                pickElments.put(nums[i], 1);
            }
        }

        // number of subsets in pickElments
        int count = 1;

        // loop through pickElments
        for (Map.Entry<Integer, Integer> entry : pickElments.entrySet()) {
            int freq = freqMap.get(entry.getKey());
            count *= (1 << freq) - 1; // 2^freq - 1
        }

        int nonPickCount = 0;
        for (int num : nums) {
            if (!pickElments.containsKey(num)) {
                nonPickCount++;
            }
        }

        return count * (1 << nonPickCount);
    }
}
