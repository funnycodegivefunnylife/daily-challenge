package leetcode.challenge.leetcode_1631;


import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Cell {
    int x;
    int y;
    int cost;

    public Cell(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int[][] cost = new int[heights.length][heights[0].length];
        cost[0][0] = 0;

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        pq.add(new Cell(0, 0, 0));

        boolean[][] visited = new boolean[heights.length][heights[0].length];

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int x = cell.x;
            int y = cell.y;

            if (x == heights.length - 1 && y == heights[0].length - 1) {
                return cell.cost;
            }

            visited[x][y] = true;

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length && !visited[newX][newY]) {
                    int newCost = Math.max(cell.cost, Math.abs(heights[newX][newY] - heights[x][y]));
                    if (cost[newX][newY] == 0 || newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        pq.add(new Cell(newX, newY, newCost));
                    }
                }
            }
        }

        return -1;
    }
}