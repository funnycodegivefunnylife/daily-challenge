package leetcode.challenge.leetcode_1267;

class Solution {
    public int countServers(int[][] grid) {

        int[] serverCountOnRow = new int[grid.length];
        int[] serverCountOnCol = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    serverCountOnCol[j]++;
                }
            }
            serverCountOnRow[i] = count;
        }

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (serverCountOnRow[i] > 1 || serverCountOnCol[j] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }
}