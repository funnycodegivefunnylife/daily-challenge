package leetcode.challenge.leetcode_1976;

import java.util.Arrays;

class Solution {
    public int countPaths(int n, int[][] roads) {

        long[] shortest = new long[n];
        boolean[] visited = new boolean[n];

        int graph[][] = new int[n][n];

        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }

        Arrays.fill(shortest, Long.MAX_VALUE);
        shortest[0] = 0;

        int[] waysToReach = new int[n];
        waysToReach[0] = 1;

        for (int i = 0; i < n; i++) {
            int min = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (min == -1 || shortest[j] < shortest[min])) {
                    min = j;
                }
            }

            visited[min] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[min][j] > 0 && shortest[min] + graph[min][j] < shortest[j]) {
                    waysToReach[j] = waysToReach[min];
                    shortest[j] = shortest[min] + graph[min][j];
                } else if (!visited[j] && graph[min][j] > 0 && shortest[min] + graph[min][j] == shortest[j]) {
                    waysToReach[j] = (waysToReach[j] + waysToReach[min]) % 1000000007;
                }
            }
        }

        return waysToReach[n - 1];
    }
}