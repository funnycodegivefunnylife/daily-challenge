package leetcode.challenge.leetcode_2290;

import java.util.PriorityQueue;

class Node {
    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Node(0, 0, 0));

        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.x == m - 1 && current.y == n - 1) {
                return current.dist;
            }

            for (int[] dir : dirs) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newDist = current.dist + (grid[newX][newY] == 1 ? 1 : 0);
                    if (newDist < dist[newX][newY]) {
                        dist[newX][newY] = newDist;
                        pq.add(new Node(newX, newY, newDist));
                    }
                }
            }
        }

        return -1;
    }
}