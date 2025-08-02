package leetcode.challenge.leetcode_2311;

class Solution {
    public int longestSubsequence(String s, int k) {

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subsequence = s.substring(i, j);
                int value = Integer.parseInt(subsequence, 2);
                if (value <= k) {
                    maxLength = Math.max(maxLength, subsequence.length());
                }
            }
        }

        return maxLength;
    }
}
