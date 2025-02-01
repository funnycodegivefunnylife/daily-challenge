package leetcode.challenge.leetcode_2563;

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int minimumAtLower = lower - nums[i];
            int maximumAtUpper = upper - nums[i];
            int firstGreaterthanFromBeginning = searchFirstGreaterthanFromBeginning(nums, 0, i, maximumAtUpper);
            int firstLessThanFromBeginning = searchFirstLessThanFromBeginning(nums, 0, i, minimumAtLower);

            count += (firstGreaterthanFromBeginning - firstLessThanFromBeginning - 1);
        }

        return count;
    }

    public int searchFirstGreaterthanFromBeginning(int[] nums, int low, int high, int value) {

        while (low < high) {
            int mid = (high - low) / 2 + low;

            if (nums[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int searchFirstLessThanFromBeginning(int[] nums, int low, int high, int value) {
        return searchFirstGreaterthanFromBeginning(nums, low, high, value - 1) - 1;
    }
}
