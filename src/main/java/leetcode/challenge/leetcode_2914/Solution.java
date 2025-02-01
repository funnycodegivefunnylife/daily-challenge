package leetcode.challenge.leetcode_2914;

class Solution {
    public int minChanges(String s) {
        int count = 0;

        for (int i = 2; i <= s.length(); i += 2) {
            boolean allTheSame = s.charAt(i - 2) == s.charAt(i - 1);
            if (!allTheSame) {
                count++;
            }
        }

        return count;
    }
}
