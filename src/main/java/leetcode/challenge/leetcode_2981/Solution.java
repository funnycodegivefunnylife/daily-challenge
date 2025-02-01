package leetcode.challenge.leetcode_2981;

import java.util.Map;

class Solution {
    public int maximumLength(String s) {
        int max = -1;

        Map<String, Integer> freq = new java.util.HashMap<>();

        int prefix[] = new int[s.length()];
        prefix[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (prefix[j] - prefix[i] == 0) {
                    freq.put(sub, freq.getOrDefault(sub, 0) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= 3) {
                max = Math.max(max, entry.getKey().length());
            }
        }

        return max;
    }
}
