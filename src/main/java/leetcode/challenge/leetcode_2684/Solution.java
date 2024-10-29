package leetcode.challenge.leetcode_2684;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] nextPoints = new int[][]{{-1, 1}, {0, 1}, {1, 1}};


    public int maxMoves(int[][] grid) {

        int dp[][] = new int[grid.length][grid[0].length];

        int nRow = grid.length;
        int nCol = grid[0].length;

        int max = 0;
        for (int i = 0; i < nRow; i++) {
            max = Math.max(max, dfs(grid, i, 0, dp));
        }

        return max;
    }

    public int dfs(int [][] grid, int row, int col, int [][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int max = 0;

        for (int[] point: nextPoints) {
            int nextRow = row + point[0];
            int nextCol = col + point[1];

            if (isValidCell(nextRow, nextCol, grid.length, grid[0].length) && grid[nextRow][nextCol] > grid[row][col]) {
                max = Math.max(max, 1 + dfs(grid, nextRow, nextCol, dp));
            }
        }

        dp[row][col] = max;

        return max;
    }

    public static boolean isValidCell(int row, int col, int nRow, int nCol) {
        return row >= 0 && row < nRow && col >= 0 && col < nCol;
    }
}