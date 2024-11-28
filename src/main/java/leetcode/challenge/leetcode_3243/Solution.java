package leetcode.challenge.leetcode_3243;

import java.util.*;

class Pair {
    int node;
    int distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];

        int[] shortestDistance = new int[n];
        shortestDistance[0] = 0;

        for (int i = 1; i < n; i++) {
            shortestDistance[i] = i;
        }

        Map<Integer, List<Integer>> adjacent = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            List<Integer> list = adjacent.getOrDefault(i, new ArrayList<>());
            list.add(i + 1);
            adjacent.put(i, list);
        }
        adjacent.put(n - 1, new ArrayList<>());

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int from = query[0];
            int to = query[1];
            List<Integer> fromAdjacent = adjacent.get(from);
            fromAdjacent.add(to);
            updateShortestDistance(adjacent, shortestDistance, from, to);
            result[i] = shortestDistance[n - 1];
        }

        return result;
    }

    private void updateShortestDistance(Map<Integer, List<Integer>> adjacentMap, int[] shortestDistance, int from, int to) {
        if (shortestDistance[to] < shortestDistance[from] + 1) {
            return;
        }

        shortestDistance[to] = shortestDistance[from] + 1;
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        queue.add(new Pair(to, shortestDistance[to]));
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (visited.contains(current.node)) {
                continue;
            }
            visited.add(current.node);
            List<Integer> adjacent = adjacentMap.get(current.node);
            for (int node : adjacent) {
                if (shortestDistance[node] > shortestDistance[current.node] + 1) {
                    shortestDistance[node] = shortestDistance[current.node] + 1;
                    queue.add(new Pair(node, shortestDistance[node]));
                }
            }
        }

    }

}