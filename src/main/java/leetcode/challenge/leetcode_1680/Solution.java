package leetcode.challenge.leetcode_1680;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }

        long result = convertToDecimal(sb.toString());

        return (int) (result % MOD);
    }

    private long convertToDecimal(String binaryString) {
        long result = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            result = (result * 2 + (binaryString.charAt(i) - '0')) % MOD;
        }

        return result;
    }
}
