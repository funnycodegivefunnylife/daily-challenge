package leetcode.challenge.leetcode_2966;

import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] rs = new int[nums.length / 3][3];

        int min = nums[0];

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] - min > k) {
                return new int[0][];
            }

            if ((i + 1) % 3 == 0) {
                rs[index][0] = min;
                rs[index][1] = nums[i - 1];
                rs[index][2] = nums[i];
                index++;
                min = i < nums.length - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            }
        }
        return rs;
    }
}
