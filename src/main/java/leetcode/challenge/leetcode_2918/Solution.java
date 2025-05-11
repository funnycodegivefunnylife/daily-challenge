package leetcode.challenge.leetcode_2918;

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zero1 = 0, zero2 = 0;
        long sum1 = 0, sum2 = 0;

        for (int num : nums1) {
            if (num == 0) zero1++;
            sum1 += num;
        }

        for (int num : nums2) {
            if (num == 0) zero2++;
            sum2 += num;
        }

        long max1 = sum1 + zero1;
        long max2 = sum2 + zero2;

        if (sum1 == sum2) {
            if (zero1 == 0 && zero2 == 0) return sum1;
            if (zero1 == 0 || zero2 == 0) return -1;
            return sum1 + Math.max(zero1, zero2);
        }

        if (sum1 < sum2) {
            if (zero1 == 0 || (zero2 == 0 && max1 > sum2)) return -1;
        } else {
            if (zero2 == 0 || (zero1 == 0 && max2 > sum1)) return -1;
        }

        return Math.max(max1, max2);
    }
}
