package leetcode.challenge.leetcode_2560;

class Solution {

    public int minCapability(int[] nums, int k) {

        int start = findMinValue(nums);
        int end = findMaxValue(nums);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canSelectKElements(nums, mid, k)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    /**
     * Check if it is possible to select k elements from nums array that are less than or equal to maxAllowedValue
     * and the selected elements are not adjacent to each other.
     *
     * @param nums
     * @param maxAllowedValue
     * @param k
     * @return
     */
    public boolean canSelectKElements(int[] nums, int maxAllowedValue, int k) {
        int selectedCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxAllowedValue) {
                selectedCount++;
                // skip the next element because it is adjacent to the current element
                i++;
            }
        }

        return selectedCount >= k;
    }

    public int findMaxValue(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public int findMinValue(int[] nums) {
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

}