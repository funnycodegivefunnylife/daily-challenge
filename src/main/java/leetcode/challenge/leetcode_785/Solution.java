package leetcode.challenge.leetcode_785;

import java.util.Arrays;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !dfs(graph, colors, i, 0)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (!dfs(graph, colors, neighbor, 1 - color)) {
                return false;
            }
        }

        return true;
    }
}
