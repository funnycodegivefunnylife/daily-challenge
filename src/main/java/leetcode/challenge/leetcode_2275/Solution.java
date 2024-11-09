package leetcode.challenge.leetcode_2275;

import java.util.Arrays;

class Solution {
    public int largestCombination(int[] candidates) {

        int maxVal = findMax(candidates);
        int nBit = countNumberOfBit(maxVal);
        int[] oneBitCounts = new int[nBit];

        for (int candidate: candidates) {
            for (int i = 0; i < nBit; i++) {
                if ((candidate & (1 << i)) != 0) {
                    oneBitCounts[i]++;
                }
            }
        }


        int max = 0;

        for (int value: oneBitCounts) {
            max = Math.max(max, value);
        }

        return max;
    }

    public int findMax(int[] candidates) {
        int max = candidates[0];

        for (int candidate: candidates) {
            max = Math.max(max, candidate);
        }
        Arrays.stream(candidates).max().getAsInt();
        return max;
    }

    public int countNumberOfBit(int n) {
        int count = 0;

        while (n > 0) {
            count += 1;
            n >>= 1;
        }

        return count;
    }
}