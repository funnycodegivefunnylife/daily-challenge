package leetcode_1813;

import leetcode.challenge.leetcode_1813.SentenceSimilarityChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSentenceSimilarityChecker {

    @Test
    @DisplayName("Given sentence1 = 'My name is Haley' and sentence2 = 'My Haley', the method should return true")
    public void test1() {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        assert SentenceSimilarityChecker.CHECKER.areSentencesSimilar(sentence1, sentence2);
    }

    @Test
    @DisplayName("Given sentence1 = 'of' and sentence2 = 'A lot of words', the method should return false")
    public void test2() {
        String sentence1 = "of";
        String sentence2 = "A lot of words";
        assert !SentenceSimilarityChecker.CHECKER.areSentencesSimilar(sentence1, sentence2);
    }

    @Test
    @DisplayName("Given sentence1 = 'Myna me is Haley' and sentence2 = 'My Haley', the method should return false")
    public void test3() {
        String sentence1 = "Myna me is Haley";
        String sentence2 = "My Haley";
        assert !SentenceSimilarityChecker.CHECKER.areSentencesSimilar(sentence1, sentence2);
    }

    @Test
    @DisplayName("Given sentence1 = 'Eating right now' and sentence2 = 'Eating', the method should return true")
    public void test4() {
        String sentence1 = "Eating right now";
        String sentence2 = "Eating";
        assert SentenceSimilarityChecker.CHECKER.areSentencesSimilar(sentence1, sentence2);
    }
    @Test
    @DisplayName("Given sentence1 = 'Are You OK' and sentence2 = 'are you ok', the method should return true")
    public void test5() {
        String sentence1 = "Are You OK";
        String sentence2 = "are you ok";
        assert !SentenceSimilarityChecker.CHECKER.areSentencesSimilar(sentence1, sentence2);
    }

    //"B"
    //sentence2 =
    //"ByI BMyQIqce b bARkkMaABi vlR RLHhqjNzCN oXvyK zRXR q ff B yHS OD KkvJA P JdWksnH"

    @Test
    @DisplayName("Given sentence1 = 'B' and sentence2 = 'ByI BMyQIqce b bARkkMaABi vlR RLHhqjNzCN oXvyK zRXR q ff B yHS OD KkvJA P JdWksnH', the method should return false")
    public void test6() {
        String sentence1 = "B";
        String sentence2 = "ByI BMyQIqce b bARkkMaABi vlR RLHhqjNzCN oXvyK zRXR q ff B yHS OD KkvJA P JdWksnH";
        assert !SentenceSimilarityChecker.CHECKER.areSentencesSimilar(sentence1, sentence2);
    }
}
