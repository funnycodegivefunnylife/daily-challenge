package leetcode.challenge.leetcode_72;

class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        char[] word2s = word2.toCharArray();
        char[] word1s = word1.toCharArray();
        for (int i = 1; i <= word1.length(); i++) {
            char first = word1s[i - 1];
            for (int j = 1; j <= word2.length(); j++) {
                char second = word2s[j - 1];

                if (first == second) {}
            }
        }

        return 0;
    }
}
