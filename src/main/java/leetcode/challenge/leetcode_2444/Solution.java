package leetcode.challenge.leetcode_2444;


class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        int start = 0;
        int maxIndex = -1;
        int minIndex = -1;
        long count = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] < minK || nums[end] > maxK) {
                start = end + 1;
                maxIndex = -1;
                minIndex = -1;
            } else {
                if (maxIndex == - 1 || nums[end] >= nums[maxIndex]) {
                    maxIndex = end;
                }

                if (minIndex == -1 || nums[end] <= nums[minIndex]) {
                    minIndex = end;
                }

                if (nums[maxIndex] == maxK && nums[minIndex] == minK) {
                    count += Math.min(maxIndex, minIndex) - start + 1;
                }
            }
        }

        return count;
    }

}

