package leetcode.challenge.leetcode_3202;

import java.util.Map;

class Solution {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> countMap = new java.util.HashMap<>();

        int maxLength = 0;
        // num always > 0
        for (int i = 0; i < nums.length; i++) {
            int mod = nums[i] % k;
            int expected = (k - mod) % k;
            int count = countMap.getOrDefault(expected, 0);
            countMap.put(mod, count + 1);
            maxLength = Math.max(maxLength, count + 1);

        }

        return maxLength;

    }
}
