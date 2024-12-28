package leetcode.challenge.leetcode_1760;

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int low = 1;
        int high = findMax(nums);

        while (low < high) {
            int mid = (high + low) / 2;

            if (canDivide(nums, maxOperations, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return low;
    }

    private int findMax(int[] nums) {
       int max = Integer.MIN_VALUE;

       for (int num: nums) {
           max = Math.max(num, max);
       }

       return max;
    }

    public boolean canDivide(int[] nums, int maxOperations, int size) {
        if (size == 0) {
            return false;
        }

        int count = 0;
        for (int num : nums) {
            if (num > size) {
                count += (num / size + (num % size == 0 ? 0 : 1)) - 1;
            }

            if (count > maxOperations) {
                return false;
            }
        }

        return count <= maxOperations;
    }
}