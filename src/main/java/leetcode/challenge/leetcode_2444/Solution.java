package leetcode.challenge.leetcode_2444;

import java.util.Deque;
import java.util.List;

class SubArray {
    int start;
    int end;

    public SubArray(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        List<SubArray> validSubArray = new java.util.ArrayList<>();

        int start = -1;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            } else {
                if (end != -1) {
                    validSubArray.add(new SubArray(start, end));
                }
                start = -1;
                end = -1;
            }
        }

        if (end != -1) {
            validSubArray.add(new SubArray(start, end));
        }
        long count = 0;

        for (SubArray subArray : validSubArray) {
            count += countSubArrays(nums, subArray.start, subArray.end, minK, maxK);
        }

        return count;
    }

    public long countSubArrays(int[] nums, int start, int end, int minK, int maxK) {
        Deque<Integer> minDeque = new java.util.ArrayDeque<>();
        Deque<Integer> maxDeque = new java.util.ArrayDeque<>();

        long count = 0;

        for (int windowEnd = start; windowEnd <= end; windowEnd++) {
           // push to minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[windowEnd]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(windowEnd);

            // push to maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[windowEnd]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(windowEnd);

           if (nums[minDeque.peekFirst()] == minK && nums[maxDeque.peekFirst()] == maxK) {
                count += Math.min(minDeque.peekFirst(), maxDeque.peekFirst()) - start + 1;
            }

        }

        return count;
    }
}