package leetcode.challenge.leetcode_2948;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;
        int i = 0;

        while (i < n - 1 && limit > 0) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = i + 1; j < n; j++) {
                int diff = nums[i] - nums[j];
                if (diff > 0 && diff <= limit && nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != -1) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }

            i++;
        }

        return nums;
    }
}
