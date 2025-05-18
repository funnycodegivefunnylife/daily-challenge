package leetcode.challenge.leetcode_819;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> nonBannedWordToFrequency = new HashMap<>();

        Set<String> bannedWords = Set.of(banned);

        StringBuilder sb = new StringBuilder();

        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                String word = sb.toString();
                if (!word.isEmpty() && !bannedWords.contains(word)) {
                    nonBannedWordToFrequency.put(word, nonBannedWordToFrequency.getOrDefault(word, 0) + 1);
                }
                sb.setLength(0);
            }
        }

        String word = sb.toString();

        if (!word.isEmpty() && !bannedWords.contains(word)) {
            nonBannedWordToFrequency.put(word, nonBannedWordToFrequency.getOrDefault(word, 0) + 1);
        }

        String mostCommonWord = null;

        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : nonBannedWordToFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }

        return mostCommonWord;
    }
}