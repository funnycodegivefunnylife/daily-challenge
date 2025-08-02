package leetcode.challenge.leetcode_190;

class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;

            result |= (n & 1);

            // Shift n to the right to process the next bit
            n >>= 1;
        }

        return result;
    }
}
