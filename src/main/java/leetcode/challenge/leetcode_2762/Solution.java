package leetcode.challenge.leetcode_2762;

import java.util.ArrayDeque;
import java.util.Deque;

class MinMaxInWindow {
    int[] nums;
    int start;
    int end;
    Deque<Integer> maxQueue = new ArrayDeque<>();
    Deque<Integer> minQueue = new ArrayDeque<>();

    public MinMaxInWindow(int[] nums) {
        this.nums = nums;
        this.start = 0;
        this.end = 0;
    }

    public void add(int index) {

        while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[index]) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(index);

        while (!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[index]) {
            minQueue.pollLast();
        }
        minQueue.addLast(index);

        end++;

        ensureDifferentStillTwo();
    }

    public void ensureDifferentStillTwo() {

        for (; start < end && nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > 2; start++) {
            // start ------ end
            if (maxQueue.peekFirst() == start) {
                maxQueue.pollFirst();
            }

            if (minQueue.peekFirst() == start) {
                minQueue.pollFirst();
            }
        }
    }

    public int getSize() {
        return end - start;
    }
}

class Solution {
    public long continuousSubarrays(int[] nums) {
        MinMaxInWindow minMaxInWindow = new MinMaxInWindow(nums);

        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            minMaxInWindow.add(i);
            result += minMaxInWindow.getSize();
        }

        return result;
    }
}
