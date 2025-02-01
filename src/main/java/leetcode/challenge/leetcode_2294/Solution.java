package leetcode.challenge.leetcode_2294;

import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int result = 1;
        int start = 0;

        boolean isCut = false;

        for (int end = 0; end < nums.length; end++) {
            if (start < end && nums[end] - nums[start] > k) {
                start = end;
                result += 1;
            }
        }

        return result;
    }
}
