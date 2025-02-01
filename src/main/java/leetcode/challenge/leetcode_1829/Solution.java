package leetcode.challenge.leetcode_1829;

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] prefixXor = new int[nums.length];

        prefixXor[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixXor[i] = nums[i] ^ prefixXor[i - 1];
        }

        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[result.length - 1 - i] = choose(prefixXor[i], maximumBit);
        }

        return result;
    }

    public int choose(int prefixXor, int maximumBit) {
        int result = 0;
        for (int i = 0; i < maximumBit; i++) {
            if ((prefixXor & (1 << i)) == 0) {
                result |= 1 << i;
            }
        }

        return result;
    }
}
