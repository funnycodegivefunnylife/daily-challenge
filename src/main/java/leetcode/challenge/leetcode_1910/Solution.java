package leetcode.challenge.leetcode_1910;

import java.util.Stack;

class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }

        return s;
    }
}