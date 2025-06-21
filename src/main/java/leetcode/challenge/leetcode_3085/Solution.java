package leetcode.challenge.leetcode_3085;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int minimumDeletions(String word, int k) {

        int[] freq = new int[26];
        int maxFreq = 0;

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
            maxFreq = Math.max(maxFreq, freq[c - 'a']);
        }

        Set<Integer> uniqueFreq = new HashSet<>();

        for (int f : freq) {
            if (f > 0) {
                uniqueFreq.add(f);
            }
        }

        int minDeletions = Integer.MAX_VALUE;


        for (int lowerBound : uniqueFreq) {
            int upperBound = lowerBound + k;
            int deletionsNeeded = countDeletions(freq, lowerBound, upperBound);
            minDeletions = Math.min(minDeletions, deletionsNeeded);
        }

        return minDeletions;
    }

    private int countDeletions(int[] freq, int lowerBound, int upperBound) {
        int deletions = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (f < lowerBound) {
                deletions += f;
            } else if (f > upperBound) {
                deletions += f - upperBound;
            }
        }
        return deletions;
    }
}
