package leetcode.challenge.leetcode_1559;

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
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
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}};

    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        DisjointSet disjointSet = new DisjointSet(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int index = i * n + j;

                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == grid[i][j]) {
                        int neighborIndex = x * n + y;

                        if (disjointSet.find(index) == disjointSet.find(neighborIndex)) {
                            return true;
                        }

                        disjointSet.union(index, neighborIndex);
                    }
                }
            }
        }

        return false;
    }
}
