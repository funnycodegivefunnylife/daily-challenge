package leetcode.challenge.leetcode_2466;

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high + 1];

        for (int i = 0; i < 2; i++) {
            dp[0] = 1;
        }

        int count[] = new int[] {zero, one};

        for (int i = 1; i <= high; i++) {
            for (int j = 0; j < 2; j++) {
                if (i - count[j] >= 0) {
                    dp[i] += dp[i - count[j]];
                    dp[i] %= 1000000007;
                }
            }
        }

        int rs = 0;

        for (int i = low; i <= high; i++) {
            rs += dp[i];
            rs %= 1000000007;
        }

        return rs;
    }
}