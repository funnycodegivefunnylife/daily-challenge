package leetcode.challenge.leetcode_3223;

class Solution {
    public int minimumLength(String s) {
        int[] characterToFrequencies = new int[26];

        for (char c : s.toCharArray()) {
            characterToFrequencies[c - 'a']++;
        }

        int numberOfDeletedPair = 0;

        for (int i = 0; i < 26; i++) {

            if (characterToFrequencies[i] >= 3) {
                // subtract 1 because one element is considered as the middle element
                //  while the rest will be considered as the left and right elements
                //  Therefore, we need to count the number of pairs that can be formed
                numberOfDeletedPair += (characterToFrequencies[i] - 1) >> 1;
            }
        }

        return s.length() - numberOfDeletedPair * 2;
    }
}
