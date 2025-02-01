package leetcode.challenge.leetcode_187;

import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10 && i < s.length(); i++) {
            sb.append(s.charAt(i));
        }

        if (sb.length() == 10) {
            map.put(sb.toString(), 1);
        }

        Set<String> result = new HashSet<>();

        for (int i = 10; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));

            String key = sb.toString();

            if (map.containsKey(key)) {
                result.add(key);
            } else {
                map.put(key, 1);
            }
        }

        return new ArrayList<>(result);
    }
}
