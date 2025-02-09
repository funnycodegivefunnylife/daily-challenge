package leetcode.challenge.leetcode_219;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(nums[i])) {
                if (i - valueToIndex.get(nums[i]) <= k) {
                    return true;
                }
            }
            valueToIndex.put(nums[i], i);
        }


        return false;
    }
}