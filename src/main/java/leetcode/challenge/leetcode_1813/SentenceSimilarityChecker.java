package leetcode.challenge.leetcode_1813;

public interface SentenceSimilarityChecker {
    SentenceSimilarityChecker CHECKER = new CommonPrefixSuffixChecker();
    boolean areSentencesSimilar(String sentence1, String sentence2);
}
