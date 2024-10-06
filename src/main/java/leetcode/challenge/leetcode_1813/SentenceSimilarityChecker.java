package leetcode.challenge.leetcode_1813;

public interface SentenceSimilarityChecker {
    SentenceSimilarityChecker CHECKER = new TwoPointerSentenceSimilarityChecker();
    boolean areSentencesSimilar(String sentence1, String sentence2);
}
