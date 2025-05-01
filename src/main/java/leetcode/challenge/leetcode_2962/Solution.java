package leetcode.challenge.leetcode_2962;

class Solution {
    public long countSubarrays(int[] nums, int k) {

        int max = findMax(nums);
        int n = nums.length;
        int[] maxFreq = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            maxFreq[i] = maxFreq[i - 1] + (nums[i - 1] == max ? 1 : 0);
        }

        long totalCount = 0L;

        int start = 0;

        for (int end = 0; end < n; end++) {
            while (start <= end && maxFreq[end + 1] - maxFreq[start + 1] >= k) {
                start++;
            }

            if (maxFreq[end + 1] - maxFreq[start] >= k) {
                totalCount += (start + 1);
            }
        }

        return totalCount;
    }

    int findMax(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
