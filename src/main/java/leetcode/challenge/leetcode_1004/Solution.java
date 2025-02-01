package leetcode.challenge.leetcode_1004;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        // principle is the amount of 0s between 1s shopuld be less than or equal to k

        int countZero = 0;
        int start = 0;
        int max = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                countZero++;
            }

            while (countZero > k) {
                if (nums[start] == 0) {
                    countZero--;
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
