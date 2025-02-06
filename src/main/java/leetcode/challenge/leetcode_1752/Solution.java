package leetcode.challenge.leetcode_1752;

class Solution {
    public boolean check(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int i = 1;

        for (; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }

        for (; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                break;
            }
        }

        if (i == nums.length - 1) {
            return nums[0] >= nums[nums.length - 1];
        }

        return i >= nums.length;
    }
}
