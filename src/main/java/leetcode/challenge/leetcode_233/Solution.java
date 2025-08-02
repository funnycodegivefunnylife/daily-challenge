package leetcode.challenge.leetcode_233;

class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            count += countDigit(i);
        }

        return count;
    }

    public int countDigit(int n) {
        return Long.bitCount(n);
    }
}
