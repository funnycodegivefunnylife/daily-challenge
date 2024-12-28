package leetcode.challenge.leetcode_689;




class DpEntry {
    int parentIndex;
    int endIndex;
    int value;

    DpEntry(int parentIndex, int endIndex, int value) {
        this.parentIndex = parentIndex;
        this.endIndex = endIndex;
        this.value = value;
    }

    public static DpEntry newInstance(int parentIndex, int index, int value) {
        return new DpEntry(parentIndex, index, value);
    }
}


class Solution {

    private static final Integer N_ARRAY_TO_RETURN = 3;

    public DpEntry[][] initTableWithDefaultState(int n) {
        DpEntry[][] dp = new DpEntry[N_ARRAY_TO_RETURN + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = DpEntry.newInstance(-1, -1, 0);
            }
        }

        return dp;
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] rs = new int[N_ARRAY_TO_RETURN];

        int n = nums.length;

        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }

        DpEntry[][] maxSumTable = initTableWithDefaultState(n);

        for (int i = 1; i <= maxSumTable.length - 1; i++) {
            for (int j = k * i; j <= n; j++) {
                int candidateSum = prefixSum[j] - prefixSum[j - k] + maxSumTable[i - 1][j - k].value;
                if (candidateSum > maxSumTable[i][j - 1].value) {
                    maxSumTable[i][j] = DpEntry.newInstance(j - k, j, candidateSum);
                } else {
                    maxSumTable[i][j] = DpEntry.newInstance(maxSumTable[i][j - 1].parentIndex, maxSumTable[i][j - 1].endIndex, maxSumTable[i][j - 1].value);
                }
            }
        }

        int index = n;
        for (int i = 2; i >= 0; i--) {
            rs[i] = maxSumTable[i + 1][index].endIndex - k;
            index = maxSumTable[i + 1][index].parentIndex;
        }

        return rs;
    }
}