package leetcode.challenge.leetcode_3097;

class ArrayBit {
    // count number of number has bit 1 at index
    int[] bits = new int[64];
    int orResult = 0;

    public void add(int n) {

        int index = 0;

        while (n > 0) {
            int bit = n & 1;

            // case 1: bits[index] > 0
            if (bit == 1) {
                bits[index]++;
            }

            if (bit == 1 && bits[index] == 1) {
                orResult |= 1 << index;
            }
            n = n >> 1;
            index++;
        }
    }

    public boolean gte(int k) {
        return orResult >= k;
    }

    public void remove(int nums) {
        int index = 0;

        while (nums > 0) {
            int bit = nums & 1;

            if (bit == 1) {
                bits[index]--;
            }

            if (bits[index] == 0) {
                orResult &= ~(1 << index);
            }

            nums = nums >> 1;
            index++;
        }
    }
}

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {

        int start = 0;

        ArrayBit arrayBit = new ArrayBit();

        arrayBit.add(nums[0]);

        if (arrayBit.gte(k)) {
            return 1;
        }

        int min = Integer.MAX_VALUE;

        for (int end = 1; end < nums.length; end++) {
            arrayBit.add(nums[end]);

            while (start <= end && arrayBit.gte(k)) {
                min = Math.min(min, end - start + 1);
                arrayBit.remove(nums[start++]);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
