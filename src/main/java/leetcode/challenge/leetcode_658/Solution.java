package leetcode.challenge.leetcode_658;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int totalDiff = 0;
        for (int i = 0; i < k; i++) {
            totalDiff += Math.abs(arr[i] - x);
        }

        int minDiff = totalDiff;
        int minIndex = 0;

        int start = 0;

        for (int i = k; i < arr.length; i++) {

            totalDiff -= Math.abs(arr[i - k] - x);
            totalDiff += Math.abs(arr[i] - x);

            if (totalDiff < minDiff) {
                minDiff = totalDiff;
                minIndex = start + 1;
            }

            start++;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = minIndex; i < minIndex + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
