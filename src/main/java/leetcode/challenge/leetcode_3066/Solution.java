package leetcode.challenge.leetcode_3066;

import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add((long) num);
        }

        int countOperations = 0;
        while (pq.size() >= 2) {
            long first = pq.poll();
            long second = pq.poll();
            if (first >= k && second >= k) {
                return countOperations;
            }
            long newElement = Math.min(first, second) * 2L + Math.max(first, second);
            pq.add(newElement);
            countOperations++;
        }

        return -1;
    }
}
