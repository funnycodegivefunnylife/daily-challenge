package leetcode.challenge.leetcode_3191;

class Solution {
    public int minOperations(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                // flip the next two elements
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
        }

        // check all elements are 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }

        return count;
    }
}
