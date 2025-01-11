package leetcode.challenge.leetcode_977;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] rs = new int[nums.length];

        Arrays.fill(rs, -1);

        int left = 0;
        int right = nums.length - 1;

        int current = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                rs[current] = leftSquare;
                left++;
            } else {
                rs[current] = rightSquare;
                right--;
            }

            current--;
        }



        return rs;
    }

}