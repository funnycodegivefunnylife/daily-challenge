package leetcode.challenge.leetcode_1818;

import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int[] diffPairs = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            diffPairs[i] = Math.abs(nums1[i] - nums2[i]);
        }

        int[] sortedNums1 = nums1.clone();
        Arrays.sort(sortedNums1);

        int maxChange = 0;

        for (int i = 0; i < nums1.length; i++) {
            int target = nums2[i];

            int closestIndex = findIndexClosest(sortedNums1, target);
            int change = Math.abs(nums1[i] - nums2[i]) - Math.abs(sortedNums1[closestIndex] - nums2[i]);

            maxChange = Math.max(maxChange, change);
        }


        long sum = 0;

        for (int i = 0; i < nums1.length; i++) {
            sum += diffPairs[i];
        }

        return (int) ((sum - maxChange) % 1000000007);
    }

    public int findIndexClosest(int[] nums, int target) {
        int firstGte = findFirstGte(nums, target);
        int firstLte = findLastLte(nums, target);

        if (firstGte == nums.length || firstGte < 0) {
            return firstLte;
        }

        if (firstLte == nums.length || firstLte < 0) {
            return firstGte;
        }

        if (Math.abs(nums[firstGte] - target) < Math.abs(nums[firstLte] - target)) {
            return firstGte;
        } else {
            return firstLte;
        }
    }

    public int findFirstGte(int[] nums, int target) {
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

    public int findLastLte(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left < right) {
            int mid = (int) Math.ceil((left + right) * 1.0/ 2);

            if (nums[mid] <= target) {
                left = mid;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        if (nums[left] <= target) {
            result = left;
        }

        return result;
    }
}