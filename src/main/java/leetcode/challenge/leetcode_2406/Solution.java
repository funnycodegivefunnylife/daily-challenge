package leetcode.challenge.leetcode_2406;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Node {
    int index;
    int start;
    int end;
    List<Node> children = new java.util.ArrayList<>();

    public boolean isIntersect(Node node) {
        return node.start == start || node.start == end || node.end == start || node.end == end;
    }

    public void addChildren(Node node) {
        if (children.contains(node)) {
            return;
        }

        children.add(node);
    }
}

class Solution {
    public int minGroups(int[][] intervals) {
        Map<Integer, Node> map = new java.util.HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            Node node = new Node();
            node.index = i;
            node.start = intervals[i][0];
            node.end = intervals[i][1];
            map.put(i, node);
        }

        for (int i = 0; i < intervals.length; i++) {
            Node node = map.get(i);
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) {
                    continue;
                }
                Node other = map.get(j);
                if (node.isIntersect(other)) {
                    node.addChildren(other);
                }
            }
        }

        int groups = 0;
        boolean[] visited = new boolean[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            if (!visited[i]) {
                groups = Math.max(groups, dfs(new ArrayList<>(), map.get(i), visited));
            }
        }

        return groups;
    }

    public int dfs(List<Integer> visitedList, Node node, boolean[] visited) {
        if (visitedList.contains(node.index)) {
            return visitedList.size();
        }

        visitedList.add(node.index);
        visited[node.index] = true;

        int result = 1;
        for (Node child : node.children) {
            result = Math.max(result, dfs(visitedList, child, visited));
        }

        visitedList.remove(visitedList.size() - 1);
        return result;
    }
}
