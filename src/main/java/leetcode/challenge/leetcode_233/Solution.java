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
        int count = 0;

        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }

        return count;
    }
}