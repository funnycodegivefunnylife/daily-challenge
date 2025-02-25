package leetcode.challenge.leetcode_1524;

class Solution {
    private static final int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 2;
        }

        int[] prefixSum = new int[arr.length];

        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = (prefixSum[i - 1] + arr[i]) % 2;
        }

        int result = 0;

        int[] count = new int[2];
        count[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            result = (result + count[1 - prefixSum[i]]) % MOD;
            count[prefixSum[i]]++;
        }

        return result;
    }
}