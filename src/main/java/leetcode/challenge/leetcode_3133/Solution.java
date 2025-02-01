package leetcode.challenge.leetcode_3133;

class Solution {
    public long minEnd(int n, int x) {

        int[] bits = new int[64];

        int xBits = countNumberOfBits(x);

        for (int i = 0; i < xBits; i++) {
            bits[i] = (x >> i) & 1;
        }

        int nextPermutation = n - 1;

        for (int i = 0; i < 64; i++) {
            if (bits[i] == 0) {
                bits[i] = nextPermutation & 1;
                nextPermutation >>= 1;
            }
        }

        long result = 0L;

        for (int i = 0; i < 64; i++) {
            result |= ((long) bits[i]) << i;
        }

        return result;
    }

    public int countNumberOfBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n >> 1;
        }
        return count;
    }
}
