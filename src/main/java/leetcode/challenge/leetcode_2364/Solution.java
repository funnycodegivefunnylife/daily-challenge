package leetcode.challenge.leetcode_2364;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {

        long totalPairs = (long) nums.length * (nums.length - 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - i;
        }

        long goodPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            goodPairs += map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return totalPairs - goodPairs;
    }

}