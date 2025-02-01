package leetcode.challenge.leetcode_522;

import java.util.Arrays;

class Solution {

    boolean isSubsequence(String a, String b) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }

    public int findLUSlength(String[] strs) {
        // sort the strings by length
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        for (int i = 0; i < strs.length; i++) {
            boolean isSubsequence = false;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    isSubsequence = true;
                    break;
                }
            }
            if (!isSubsequence) {
                return strs[i].length();
            }
        }

        return -1;
    }
}
