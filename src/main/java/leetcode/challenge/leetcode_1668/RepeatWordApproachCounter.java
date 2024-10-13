package leetcode.challenge.leetcode_1668;

import java.util.ArrayList;
import java.util.List;

public class RepeatWordApproachCounter implements IMaximumRepeatingSubstringCounter {
    @Override
    public int maxRepeating(String sequence, String word) {

        int k = 0;

        while (sequence.contains(word.repeat(k + 1))) {
            k++;
        }

        return k;
    }
}

