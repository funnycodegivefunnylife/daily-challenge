package leetcode.challenge.leetcode_684;

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
    public int[] findRedundantConnection(int[][] edges) {

        DisjointSet disjointSet = new DisjointSet(edges.length + 1);

        for (int[] edge : edges) {

            if (disjointSet.find(edge[0]) == disjointSet.find(edge[1])) {
                return edge;
            }

            disjointSet.union(edge[0], edge[1]);
        }

        return new int[0];
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length + 1);
        int[] parent = new int[edges.length + 1];
        int[] candidate1 = null;
        int[] candidate2 = null;

        for (int[] edge : edges) {
            if (parent[edge[1]] != 0) {
                candidate1 = new int[] {parent[edge[1]], edge[1]};
                candidate2 = new int[] {edge[0], edge[1]};
                continue;
            }

            parent[edge[1]] = edge[0];

            if (disjointSet.find(edge[0]) == disjointSet.find(edge[1])) {
                return candidate1 == null ? edge : candidate1;
            }

            disjointSet.union(edge[0], edge[1]);
        }

        return candidate2;
    }
}
