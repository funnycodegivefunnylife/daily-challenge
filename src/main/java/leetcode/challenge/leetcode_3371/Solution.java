package leetcode.challenge.leetcode_3371;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> intToCount = new HashMap<>();

        for (int num : nums) {
            intToCount.put(num, intToCount.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int max = Integer.MIN_VALUE;

        for (int toRemove : nums) {

            int remainingSum = sum - toRemove;
            if (remainingSum % 2 != 0) {
                continue;
            }

            int sumOfSpecialElements = remainingSum / 2;
            int sumOfSpecialElementsFreq = intToCount.getOrDefault(sumOfSpecialElements, 0);
            if (toRemove != sumOfSpecialElements && sumOfSpecialElementsFreq > 0) {
                max = Math.max(max, toRemove);
            }
            if (sumOfSpecialElementsFreq > 1) {
                max = Math.max(max, toRemove);
            }
        }

        return max;
    }
}
