package leetcode.challenge.leetcode_2558;

import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int gift : gifts) {
            queue.add(gift);
        }

        int selected = 0;

        while (selected < k && !queue.isEmpty()) {
            Integer poll = queue.poll();
            selected++;
            queue.add((int) Math.sqrt(poll));
        }

        long sum = 0;

        while (!queue.isEmpty()) {
            sum += queue.poll();
        }

        return sum;
    }
}