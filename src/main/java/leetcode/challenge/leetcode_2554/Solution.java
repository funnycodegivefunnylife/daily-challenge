package leetcode.challenge.leetcode_2554;

import java.util.Arrays;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);

        int sum = 0;
        int count = 0;
        int prev = 0;

        for (int i = 0; i < banned.length; i++) {
            for (int j = prev + 1; j < banned[i] && j <= n; j++) {
                sum += j;
                if (sum <= maxSum) {
                    count++;
                } else {
                    return count;
                }
            }
            prev = banned[i];
        }

        for (int i = banned[banned.length - 1] + 1; i <= n && sum < maxSum; i++) {
            sum += i;
            if (sum <= maxSum) {
                count++;
            }
        }

        return count;
    }
}
