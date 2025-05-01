package leetcode.challenge.leetcode_2420;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] trackInc = new int[n];
        int[] trackDec = new int[n];

        Arrays.fill(trackInc, 1);
        Arrays.fill(trackDec, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                trackInc[i] = trackInc[i - 1] + 1;
            }
            if (nums[i] <= nums[i - 1]) {
                trackDec[i] = trackDec[i - 1] + 1;
            }
        }

        List<Integer> goodIndices = new ArrayList<>();

        for (int i = k; i < n; i++) {
            if (isGoodIndex(i, trackInc, trackDec, k)) {
                goodIndices.add(i);
            }
        }

        return goodIndices;
    }

    boolean isGoodIndex(int index, int[] trackInc, int[] trackDec, int k) {
        if (index < k || index >= trackInc.length - k) {
            return false;
        }

        int nonIncre = trackDec[index - 1] - trackDec[index - k] + 1;
        int nonDec = trackInc[index + k] - trackInc[index + 1] + 1;

        return nonIncre == k && nonDec == k;
    }
}
