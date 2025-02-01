package leetcode.challenge.leetcode_329;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int[][] inDegrees = new int[matrix.length][matrix[0].length];
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                        inDegrees[x][y]++;
                    }
                }
            }
        }

        Queue<int[]> zeroInDegreeCells = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (inDegrees[i][j] == 0) {
                    zeroInDegreeCells.add(new int[] {i, j});
                }
            }
        }

        int[][] maxPath = new int[matrix.length][matrix[0].length];
        int result = 0;

        while (!zeroInDegreeCells.isEmpty()) {
            int[] cell = zeroInDegreeCells.poll();
            int i = cell[0];
            int j = cell[1];

            if (maxPath[i][j] > result) {
                result = maxPath[i][j];
            }

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];

                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                    maxPath[x][y] = Math.max(maxPath[x][y], maxPath[i][j] + 1);
                    inDegrees[x][y]--;

                    if (inDegrees[x][y] == 0) {
                        zeroInDegreeCells.add(new int[] {x, y});
                    }
                }
            }
        }

        return result + 1;
    }
}
