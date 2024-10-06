package leetcode.challenge.leetcode_1813;

import java.util.ArrayList;
import java.util.List;

public class TwoPointerSentenceSimilarityChecker implements SentenceSimilarityChecker{
    @Override
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        return isPrefixAndSuffix(sentence1, sentence2) || isPrefixAndSuffix(sentence2, sentence1)
                || sentence1.equals(sentence2) || sentence1.startsWith(sentence2 + " ") || sentence1.endsWith(" " + sentence2)
                || sentence2.startsWith(sentence1 + " ") || sentence2.endsWith(" " + sentence1);
    }

    private boolean isPrefixAndSuffix(String toBreak, String toCheck) {
        if (toBreak.length() > toCheck.length()) {
            return false;
        }

        List<Integer> indexOfSpaces = new ArrayList<>();

        for (int i = 0; i < toBreak.length(); i++) {
            if (toBreak.charAt(i) == ' ') {
                indexOfSpaces.add(i);
            }
        }

        for (int i = 0; i < indexOfSpaces.size(); i++) {
            int index = indexOfSpaces.get(i);
            String prefix = toBreak.substring(0, index) + " ";
            String suffix = " " + toBreak.substring(index + 1);

            if (toCheck.startsWith(prefix) && toCheck.endsWith(suffix)) {
                return true;
            }

        }

        return false;
    }
}
