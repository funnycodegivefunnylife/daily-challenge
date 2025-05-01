package leetcode.challenge.leetcode_3113;

import java.util.Deque;
import java.util.Map;

class Solution {
    public long numberOfSubarrays(int[] nums) {
        long count = 0L;

        int n = nums.length;

        Deque<Integer> decrease = new java.util.ArrayDeque<>();
        Map<Integer, Integer> freq = new java.util.HashMap<>();

        for (int end = 0; end < n; end++) {

            while (!decrease.isEmpty() && nums[decrease.peekLast()] < nums[end]) {
                freq.remove(nums[decrease.peekLast()]);
                decrease.pollLast();
            }

            if (decrease.isEmpty() || nums[decrease.peekLast()] > nums[end]) {
                decrease.addLast(end);
            }

            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

            count += freq.get(nums[end]);
        }

        return count;
    }
}
