package leetcode.challenge.leetcode_2017;

class Solution {

    public long gridGame(int[][] grid) {
        long rs = 0;
        long totalPoints = 0;
        for (int i = 0; i < grid[0].length; i++) {
            totalPoints += grid[0][i];
            totalPoints += grid[1][i];
        }

        grid[1][0] += grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            // point on top
            grid[0][i] = grid[0][i - 1] + grid[0][i];
            // point on bottom
            grid[1][i] = Math.max(grid[0][i], grid[1][i - 1]) + grid[1][i];
        }

        return totalPoints - grid[1][grid[0].length - 1];
    }
}
