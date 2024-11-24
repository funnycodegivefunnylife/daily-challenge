package leetcode.challenge.leetcode_1975;

class Solution {
    public long maxMatrixSum(int[][] matrix) {

        long absSum = 0;
        int countNeg = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                absSum += Math.abs(matrix[i][j]);
                if (matrix[i][j] < 0) {
                    countNeg++;
                }
                minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
            }
        }

        if (countNeg % 2 == 0) {
            return absSum;
        }

        return absSum - 2 * minAbs;
    }
}