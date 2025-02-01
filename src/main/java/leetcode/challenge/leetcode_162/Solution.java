package leetcode.challenge.leetcode_162;

class Solution {
    public int findPeakElement(int[] nums) {

       int low = 0;
       int high = nums.length - 1;

         while (low < high) {
              int mid = low + (high - low) / 2;
              if (isPeak(nums, mid)) {
                return mid;
              } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
              } else {
                high = mid;
              }
         }

            return low;
    }

    public boolean isPeak(int[] nums, int i) {
        if (i == 0) {
            return nums.length == 0 || nums[i] > nums[i + 1];
        } else if (i == nums.length - 1) {
            return nums[i] > nums[i - 1];
        } else {
            return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
        }
    }
}