package leetcode.challenge.leetcode_594;

import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int maxLength = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (frequencyMap.containsKey(num + 1)) {
                maxLength = Math.max(maxLength, count + frequencyMap.get(num + 1));
            }
        }

        return maxLength;
    }
}
