package leetcode.challenge.leetcode_3254;

import java.util.Stack;

class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int start = 0;
        int[] result= new int[nums.length - k + 1];
        if (nums.length == 1 && k == 1) {
            result[0] = nums[0];
        }

        for (int end = 1; end < nums.length; end++) {

            if (nums[end] != nums[end - 1] + 1) {
                start = end;
            }

            if (end - start + 1 >= k) {
                result[end - k + 1] = nums[end];
            } else if (end >= k - 1) {
                result[end - k + 1] = -1;
            }
        }

        return result;
    }
}