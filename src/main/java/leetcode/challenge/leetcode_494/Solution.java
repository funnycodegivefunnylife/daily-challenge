package leetcode.challenge.leetcode_494;

class Node {
    int index;
    int sum;

    public Node(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int[][] dp = new int[n][2001];

        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < n; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }

        return target > 1000 ? 0 : dp[n - 1][target + 1000];
    }
}
