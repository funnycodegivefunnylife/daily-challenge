package leetcode.challenge.leetcode_862;

import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {

        long prefixSum[] = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> queue = new ArrayDeque<>();

        int result = Integer.MAX_VALUE;

        for (int end = 0; end <= nums.length; end++) {

            while (!queue.isEmpty() && prefixSum[end] - prefixSum[queue.peek()] >= k) {
                result = Math.min(result, end - queue.poll());
            }

            while (!queue.isEmpty() && prefixSum[end] <= prefixSum[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.offer(end);
        }

        return result > nums.length ? -1 : result;
    }
}
