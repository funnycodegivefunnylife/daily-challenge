package leetcode.challenge.leetcode_49;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> bitMaskToListStr = new HashMap<>();

        for (String str : strs) {
            String rearranged = rearrange(str);
            bitMaskToListStr
                    .computeIfAbsent(rearranged, k -> new java.util.ArrayList<>())
                    .add(str);
        }

        return new java.util.ArrayList<>(bitMaskToListStr.values());
    }

    public String rearrange(String str) {
        char[] chars = str.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}
