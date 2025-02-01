package leetcode.challenge.leetcode_327;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length + 1];

        prefixSum[0] = 0;
        int count = 0;

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= nums.length; i++) {
            long newLower = prefixSum[i] - upper;
            long newUpper = prefixSum[i] - lower;

            for (int j = 0; j < i; j++) {
                if (prefixSum[j] >= newLower && prefixSum[j] <= newUpper) {
                    count++;
                }
            }
        }
        return count;
    }
}
