package leetcode.challenge.leetcode_525;

class Solution {
    public int findMaxLength(int[] nums) {
        int[] prefixSums = new int[nums.length + 1];
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j += 2) {
                if (prefixSums[j] - prefixSums[i] == (j - i) / 2) {
                    result = Math.max(result, j - i);
                }
            }
        }

        return result;
    }
}
