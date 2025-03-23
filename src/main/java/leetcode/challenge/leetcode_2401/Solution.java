package leetcode.challenge.leetcode_2401;

class Solution {
    public int longestNiceSubarray(int[] nums) {

        int low = 1;
        int high = nums.length;
        int result = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (validNiceSubArray(nums, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public boolean validNiceSubArray(int[] nums, int length) {
        if (length == 1) {
            return true;
        }
        for (int i = 0; i <= nums.length - length; i++) {
            int bitMask = 0;
            boolean isNice = true;

            for (int j = i; j < i + length; j++) {
                if ((bitMask & nums[j]) != 0) {
                    isNice = false;
                    break;
                }

                bitMask |= nums[j];
            }

            if (isNice) {
                return true;
            }
        }
        return false;
    }
}
