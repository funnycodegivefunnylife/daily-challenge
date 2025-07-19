package leetcode.challenge.leetcode_205;

import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sCharToTChar = new java.util.HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sCharToTChar.containsKey(sChar)) {
                if (sCharToTChar.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (sCharToTChar.containsValue(tChar)) {
                    return false;
                }
                sCharToTChar.put(sChar, tChar);
            }
        }

        return true;
    }


}
