package leetcode.challenge.leetcode_2559;

class Solution {

    private static final char[] VOWELS = new char[] {'a', 'e', 'i', 'o', 'u'};
    private static int VOWEL_BITMASK = 0;
    static {
        for (int i = 0; i < VOWELS.length; i++) {
            VOWEL_BITMASK |= 1 << (VOWELS[i] - 'a');
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length + 1];

        int idx = 1;
        for (String word: words) {
            char[] charArray = word.toCharArray();

            prefixSum[idx] = prefixSum[idx - 1];

            // start and end with vowel
            if (isVowel(charArray[0]) && isVowel(charArray[charArray.length - 1])) {
                prefixSum[idx]++;
            }
            idx++;
        }

        int[] rs = new int[queries.length];
        idx = 0;
        for (int[] query: queries) {
            rs[idx++] = prefixSum[query[1] + 1] - prefixSum[query[0]];
        }

        return rs;
    }

    boolean isVowel(char c) {
        return (VOWEL_BITMASK & (1 << (c - 'a'))) != 0;
    }
}