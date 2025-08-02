package leetcode.challenge.leetcode_417;

import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return List.of();
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, rows - 1, j);
        }

        return getResult(pacific, atlantic);
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        int rows = heights.length;
        int cols = heights[0].length;

        // Directions: up, down, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow >= 0
                    && newRow < rows
                    && newCol >= 0
                    && newCol < cols
                    && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, visited, newRow, newCol);
            }
        }
    }

    private List<List<Integer>> getResult(boolean[][] pacific, boolean[][] atlantic) {
        List<List<Integer>> result = new java.util.ArrayList<>();

        int rows = pacific.length;
        int cols = pacific[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }
}
