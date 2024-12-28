package leetcode.challenge.leetcode_2577;


import java.util.Comparator;
import java.util.PriorityQueue;

class Cell {
    int x;
    int y;
    int time;
    Cell(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {
    public int minimumTime(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int shortestTime[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                shortestTime[i][j] = Integer.MAX_VALUE;
            }
        }

        shortestTime[0][0] = grid[0][0];

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));

        int[][] visited = new int[n][m];

        pq.add(new Cell(0, 0, 0));

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            Cell currentRoom = pq.poll();

            if (currentRoom.x == n - 1 && currentRoom.y == m - 1) {
                return currentRoom.time;
            }

            if (visited[currentRoom.x][currentRoom.y] > 0) {
                continue;
            }

            visited[currentRoom.x][currentRoom.y] = 1;

            for (int[] dir : dirs) {
                int newX = currentRoom.x + dir[0];
                int newY = currentRoom.y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int newTime = currentRoom.time + 1;
                    if (newTime >= grid[newX][newY] && newTime < shortestTime[newX][newY]) {
                        shortestTime[newX][newY] = newTime;
                        pq.add(new Cell(newX, newY, newTime));
                    }

                }
            }

        }
        return -1;
    }
}