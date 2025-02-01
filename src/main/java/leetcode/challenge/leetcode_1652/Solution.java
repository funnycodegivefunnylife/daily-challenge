package leetcode.challenge.leetcode_1652;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] prefixSums = new int[code.length + 1];

        for (int i = 1; i <= code.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + code[i - 1];
        }

        int result[] = new int[code.length];

        for (int i = 1; i <= code.length; i++) {
            if (k < 0) {
                result[i - 1] = calculateSum(prefixSums, i + k, i - 1);
            } else if (k == 0) {
                result[i - 1] = 0;
            } else {
                result[i - 1] = calculateSum(prefixSums, i + 1, i + k);
            }
        }

        return result;
    }

    public int calculateSum(int[] prefixSums, int start, int end) {
        int sum = 0;
        int n = prefixSums.length;
        if (start <= 0) {
            sum += calculateSum(prefixSums, n - 1 + start, n - 1);
            start = 1;
        }

        if (end >= n) {
            sum += calculateSum(prefixSums, 1, end % n + 1);
            end = n - 1;
        }

        return sum + prefixSums[end] - prefixSums[start - 1];
    }
}
