package leetcode.challenge.leetcode_1422;

class Solution {
    public int maxScore(String s) {
        int zeros[] = new int[s.length() + 1];
        int ones[] = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            zeros[i + 1] = zeros[i] + (s.charAt(i) == '0' ? 1 : 0);
            ones[i + 1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            count = Math.max(count, zeros[i] + ones[s.length()] - ones[i]);
        }

        return count;
    }
}
