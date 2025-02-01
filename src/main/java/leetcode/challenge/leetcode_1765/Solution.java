package leetcode.challenge.leetcode_1765;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] heights = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    heights[i][j] = 0;
                } else {
                    heights[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int direction[][] = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int i = front[0], j = front[1];

            for (int[] dir : direction) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n && heights[x][y] > heights[i][j] + 1) {
                    heights[x][y] = heights[i][j] + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }

        return heights;
    }
}
