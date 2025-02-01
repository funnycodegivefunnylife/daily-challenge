package leetcode.challenge.leetcode_1755;

import java.util.Arrays;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {

        Arrays.sort(nums);
        
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }

        int[][] dp = new int[goal + 1][n + 1];

        for (int i = 0; i <= goal; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                dp[i][j] = Math.min(dp[i][j], Math.abs(i - nums[j - 1]) + dp[i - nums[j - 1]][j - 1]);
            }
        }

        return dp[goal][n];
    }

}