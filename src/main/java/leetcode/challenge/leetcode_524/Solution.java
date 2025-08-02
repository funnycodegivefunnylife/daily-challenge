package leetcode.challenge.leetcode_524;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 524
 *
 * TODO: Add problem description and link
 * Link: https://leetcode.com/problems/
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        List<String> matchingWords = new ArrayList<>();

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                matchingWords.add(word);
            }
        }

        if (matchingWords.isEmpty()) {
            return "";
        }

        matchingWords.sort((a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(b.length(), a.length());
            } else {
                return a.compareTo(b);
            }
        });
        return matchingWords.get(0);
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
