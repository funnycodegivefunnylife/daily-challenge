package leetcode.challenge.leetcode_916;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        int maxFreq[] = new int[26];

        for (String word : words2) {
            int freq[] = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words1) {
            int freq[] = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(word);
            }
        }

        return result;
    }
}