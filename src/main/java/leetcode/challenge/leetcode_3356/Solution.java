package leetcode.challenge.leetcode_3356;

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {

        int start = 0;
        int end = queries.length;

        if (!valid(nums, queries, queries.length)) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (valid(nums, queries, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean valid(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            int val = query[2];

            diff[left] += val;
            diff[right + 1] -= val;
        }

        int currentMaxDecrease = 0;

        for (int i = 0; i < n; i++) {
            currentMaxDecrease += diff[i];
            if (currentMaxDecrease < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
