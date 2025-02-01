package leetcode.challenge.leetccode_2593;

import java.util.PriorityQueue;

class Element {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Element> queue =
                new PriorityQueue<>((a, b) -> b.value == a.value ? a.index - b.index : a.value - b.value);
        int[] visited = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            queue.add(new Element(nums[i], i));
        }

        long score = 0;

        while (!queue.isEmpty()) {
            Element poll = queue.poll();
            int index = poll.index;
            int value = poll.value;

            if (visited[index] == 1) {
                continue;
            }

            score += value;
            visited[index] = 1;

            if (index > 0) {
                visited[index - 1] = 1;
            }

            if (index < nums.length - 1) {
                visited[index + 1] = 1;
            }
        }

        return score;
    }
}
