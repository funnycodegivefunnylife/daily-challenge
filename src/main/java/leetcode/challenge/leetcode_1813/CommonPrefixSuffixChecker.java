package leetcode.challenge.leetcode_1813;

import leetcode.challenge.shared.StringUtil;

public class CommonPrefixSuffixChecker implements SentenceSimilarityChecker {
    @Override
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int sizeOfLongestCommonPrefix = StringUtil.sizeOfLongestCommonPrefix(words1, words2);
        int sizeOfLongestCommonSuffix = StringUtil.sizeOfLongestCommonSuffix(words1, words2);

        // Calculate the number of remaining unmatched words in both sentences
        int unmatchedWords1 = words1.length - sizeOfLongestCommonPrefix - sizeOfLongestCommonSuffix;
        int unmatchedWords2 = words2.length - sizeOfLongestCommonPrefix - sizeOfLongestCommonSuffix;

        // If both sentences can be made similar by inserting unmatched words, return true
        return unmatchedWords1 <= 0 || unmatchedWords2 <= 0;
    }
}
