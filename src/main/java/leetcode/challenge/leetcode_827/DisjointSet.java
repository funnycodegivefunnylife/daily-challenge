package leetcode.challenge.leetcode_827;

import java.util.LinkedList;
import java.util.Queue;

class DisjointSet {
    int[] parent;
    int[] rank;
    int[] clusterSize;


    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        clusterSize = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            clusterSize[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            clusterSize[rootX] += clusterSize[rootY];
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            clusterSize[rootY] += clusterSize[rootX];
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
            clusterSize[rootX] += clusterSize[rootY];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        DisjointSet disjointSet = new DisjointSet(m * n);

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int maxIsland = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        disjointSet.union(i * n + j, x * n + y);
                        maxIsland = Math.max(maxIsland, disjointSet.clusterSize[disjointSet.find(i * n + j)]);
                    }
                }
            }

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    continue;
                }

                int islandSize = 1;
                boolean[] visited = new boolean[m * n];

                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        int root = disjointSet.find(x * n + y);
                        if (!visited[root]) {
                            islandSize += disjointSet.clusterSize[root];
                            visited[root] = true;
                        }
                    }
                }

                maxIsland = Math.max(maxIsland, islandSize);
            }
        }

        return maxIsland;
    }


}