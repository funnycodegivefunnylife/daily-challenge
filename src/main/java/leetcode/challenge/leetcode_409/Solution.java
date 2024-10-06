package leetcode.challenge.leetcode_409;

import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new java.util.HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        boolean hasOdd = false;
        for (int v : count.values()) {
            if (v % 2 == 0) {
                result += v;
            } else {
                result += v - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? result + 1 : result;
    }
}