package leetcode.challenge.leetcode_2016;

class Solution {
    public int maximumDifference(int[] nums) {
        int rs = -1;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
                maxIndex = i;
            } else if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }

            if (maxIndex > minIndex) {
                rs = Math.max(rs, nums[maxIndex] - nums[minIndex]);
            }
        }

        return rs;
    }
}