package leetcode.challenge.leetcode_2342;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumSum(int[] nums) {
        int[] digitSum = new int[nums.length];
        int maxPairSum = -1;

        Map<Integer, int[]> sumDigitToMaxPair  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            digitSum[i] = sumDigits(nums[i]);

            if (!sumDigitToMaxPair.containsKey(digitSum[i])) {
                sumDigitToMaxPair.put(digitSum[i], new int[] {nums[i], -1});
            } else {
                int[] twoMax = sumDigitToMaxPair.get(digitSum[i]);
                if (nums[i] > twoMax[0]) {
                    twoMax[1] = twoMax[0];
                    twoMax[0] = nums[i];
                } else if (nums[i] > twoMax[1]) {
                    twoMax[1] = nums[i];
                }

                if (twoMax[1] != -1) {
                    maxPairSum = Math.max(maxPairSum, twoMax[0] + twoMax[1]);
                }
            }
        }

        return maxPairSum;
    }

    public int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }
}