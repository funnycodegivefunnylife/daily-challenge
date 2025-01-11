package leetcode.challenge.leetcode_2869;

import java.util.List;

class Solution {
    public int minOperations(List<Integer> nums, int k) {
        long targetBitmask = (1L << k) - 1;


        int i;
        int count = 0;

        for (i = nums.size() - 1; i >= 0 && count < k; i--) {
            int num = nums.get(i);
            if (num <= k) {
                boolean isBitSet = (targetBitmask & (1L << (num - 1))) != 0;
                if (isBitSet) {
                    count++;
                    targetBitmask &= ~(1L << (num - 1));
                }
            }
        }
        
        return nums.size() - i - 1;
    }
}