package leetcode.challenge.leetcode_2461;

import java.util.HashMap;
import java.util.Map;

class TrackWindow {
    Map<Integer, Integer> map = new HashMap<>();
    int countDistinct = 0;
    long sum = 0;

    public void add(int num) {
        sum += num;
        map.put(num, map.getOrDefault(num, 0) + 1);
        if (map.get(num) == 1) {
            countDistinct++;
        }
    }

    public void remove(int num) {
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0) {
            countDistinct--;
        }
        sum -= num;
    }

    public boolean equalDistinct(int k) {
        return countDistinct == k;
    }
}

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long maxSum = 0;

        TrackWindow window = new TrackWindow();

        int n = nums.length;

        int start = 0;

        for (int end = 0; end < n; end++) {
            window.add(nums[end]);

            if (end - start + 1 > k) {
                window.remove(nums[start++]);
            }

            if (window.equalDistinct(k)) {
                maxSum = Math.max(maxSum, window.sum);
            }
        }
        return maxSum;
    }
}
