package leetcode.challenge.leetcode_2200;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 2200
 * 
 * TODO: Add problem description and link
 * Link: https://leetcode.com/problems/
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
class Solution {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int latestKeyIndex = -1;
        boolean[] isKDistant = new boolean[nums.length];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                latestKeyIndex = i;
            }
            if (latestKeyIndex != -1 && Math.abs(latestKeyIndex - i) <= k) {
                isKDistant[i] = true;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == key) {
                latestKeyIndex = i;
            }
            if (latestKeyIndex != -1 && Math.abs(latestKeyIndex - i) <= k) {
                if (!result.contains(i)) {
                    isKDistant[i] = true;
                }
            }
        }

        for (int i = 0; i < isKDistant.length; i++) {
            if (isKDistant[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
