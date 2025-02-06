package leetcode.challenge.leetcode_3105;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int longestIncreasing = 1;
        int longestDecreasing = 1;

        int increasing = 1;
        int decreasing = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing++;
                decreasing = 1;
            } else if (nums[i] < nums[i - 1]) {
                decreasing++;
                increasing = 1;
            } else {
                increasing = 1;
                decreasing = 1;
            }

            longestIncreasing = Math.max(longestIncreasing, increasing);
            longestDecreasing = Math.max(longestDecreasing, decreasing);
        }

        return Math.max(longestIncreasing, longestDecreasing);
    }
}