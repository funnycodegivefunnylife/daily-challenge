package leetcode.challenge.leetcode_2131;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordToCount = new HashMap<>();

        for (String word : words) {
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
        }

        int pairCount = 0;

        Set<String> seen = new HashSet<>();

        boolean hasOddPalindrome = false;

        for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (seen.contains(word)) {
                continue;
            }

            String reversedWord = new StringBuilder(word).reverse().toString();

            if (word.equals(reversedWord)) {
                pairCount += count / 2;
                if (count % 2 == 1) {
                    hasOddPalindrome = true; // We can use one odd palindrome in the center
                }
            } else if (wordToCount.containsKey(reversedWord)) {
                pairCount += Math.min(count, wordToCount.get(reversedWord));
            }

            seen.add(word);
            seen.add(reversedWord);
        }

        return pairCount * 4 + (hasOddPalindrome ? 2 : 0);
    }
}
