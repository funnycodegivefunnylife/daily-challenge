package leetcode.challenge.leetcode_2529;

class Solution {
    public int maximumCount(int[] nums) {

        int rightMostOfNegative = findRightMostOf(nums, -1);
        int leftMostOfPositive = findLeftMostOf(nums, 1);

        int numOfNegatives = rightMostOfNegative != -1 ? rightMostOfNegative + 1 : 0;
        int numOfPositives = leftMostOfPositive != -1 ? nums.length - leftMostOfPositive - 1 : 0;

        return Math.max(numOfNegatives, numOfPositives);
    }

    public int findLeftMostOf(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int findRightMostOf(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean found = false;

        while (left < right) {
            int mid = (int) Math.ceil((left + right) / 2.0);

            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }

            if (nums[mid] == target) {
                found = true;
            }
        }

        return found ? left : -1;
    }
}
