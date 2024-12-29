package leetcode.challenge.leetcode_1639;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1000000007;

    public int numWays(String[] words, String target) {

        long dp[][] = new long[target.length() + 1][words[0].length() + 1];
        int wordLength = words[0].length();

        for (int i = 0; i <= wordLength; i++) {
            dp[0][i] = 1;
        }

        Map<Integer, Integer>[] countMap = new Map[wordLength];

        for (int i = 0; i < wordLength; i++) {
            countMap[i] = new HashMap<>();
        }

        for (String word : words) {
            for (int i = 0; i < wordLength; i++) {
                int charIndex = word.charAt(i);
                countMap[i].put(charIndex, countMap[i].getOrDefault(charIndex, 0) + 1);
            }
        }

        for (int i = 1; i <= target.length(); i++) {
            int targetChar = target.charAt(i - 1);
            for (int j = i; j <= wordLength; j++) {
                long count = dp[i][j - 1] + countAtIndex(countMap, j - 1, targetChar) * dp[i - 1][j - 1];
                dp[i][j] += (count % MOD);
            }
        }

        long rs = dp[target.length()][wordLength];

        return (int) (rs % MOD);
    }

    private int countAtIndex(Map<Integer, Integer>[] countMap, int i, int targetChar) {
        return countMap[i].getOrDefault(targetChar, 0);
    }

    private int countAtIndex(String[] words, int i, int targetChar) {
        int count = 0;
        for (String word : words) {
            if (targetChar == word.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}