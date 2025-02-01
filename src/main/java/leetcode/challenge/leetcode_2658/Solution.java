package leetcode.challenge.leetcode_2658;

class Solution {

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findMaxFish(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxFish = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                maxFish = Math.max(maxFish, dfs(grid, i, j, visited));
            }
        }

        return maxFish;
    }

    int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;

        int maxFish = grid[i][j];

        for (int k = 0; k < 4; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];

            maxFish += dfs(grid, x, y, visited);
        }

        return maxFish;
    }
}