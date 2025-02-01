package leetcode.challenge.leetcode_1763;

class Solution {
    public String longestNiceSubstring(String s) {

        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int lowercaseBitmask = 0;
            int uppercaseBitmask = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (Character.isLowerCase(c)) {
                    lowercaseBitmask |= 1 << (c - 'a');
                } else {
                    uppercaseBitmask |= 1 << (c - 'A');
                }
                if (lowercaseBitmask == uppercaseBitmask && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}
