package leetcode.challenge.leetcode_718;

class Solution {
    /**
     * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
     *
     * @param nums1
     * @param nums2
     * @return the maximum length of a subarray that appears in both arrays
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
