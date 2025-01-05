package leetcode.challenge.leetcode_2270;

class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long leftSum = prefixSum[i + 1];
            long rightSum = prefixSum[nums.length] - leftSum;

            count += leftSum >= rightSum ? 1: 0;
        }

        return count;
    }
}