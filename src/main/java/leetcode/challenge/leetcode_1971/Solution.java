package leetcode.challenge.leetcode_1971;

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
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet disjointSet = new DisjointSet(n);

        for (int[] edge : edges) {
            disjointSet.union(edge[0], edge[1]);
        }

        return disjointSet.find(source) == disjointSet.find(destination);
    }
}