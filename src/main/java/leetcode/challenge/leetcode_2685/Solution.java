package leetcode.challenge.leetcode_2685;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UnionFind {
    int[] parent;
    int[] rank;
    int[] edgeCount;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        edgeCount = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int i) {
        if (parent[i] != i) {
            parent[i] = findParent(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int parentI = findParent(i);
        int parentJ = findParent(j);
        if (parentI != parentJ) {
            if (rank[parentI] > rank[parentJ]) {
                parent[parentJ] = parentI;
                edgeCount[parentI] += edgeCount[parentJ] + 1;
            } else if (rank[parentI] < rank[parentJ]) {
                parent[parentI] = parentJ;
                edgeCount[parentJ] += edgeCount[parentI] + 1;
            } else {
                parent[parentJ] = parentI;
                rank[parentI]++;
                edgeCount[parentI] += edgeCount[parentJ] + 1;
            }
        }
    }

    public Map<Integer, List<Integer>> getRankToNodes() {
        Map<Integer, List<Integer>> rankToNodes = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int parentI = findParent(i);
            rankToNodes.putIfAbsent(parentI, new ArrayList<>());
            rankToNodes.get(parentI).add(i);
        }
        return rankToNodes;
    }

    public int getEdgeCount(int i) {
        return edgeCount[findParent(i)];
    }
}

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        Map<Integer, List<Integer>> rankToNodes = uf.getRankToNodes();

        int count = 0;

        for (List<Integer> nodes : rankToNodes.values()) {
            int edgeCount = uf.getEdgeCount(nodes.get(0));

            if (edgeCount >= nodes.size() * (nodes.size() - 1) / 2) {
                count++;
            }
        }

        return count;
    }
}
