package leetcode.challenge.leetcode_802;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    List<Node> inComingEdges;
    int outDegree;

    Node(int val) {
        this.val = val;
        inComingEdges = new ArrayList<>();
    }
}


class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes[graph[i][j]].inComingEdges.add(nodes[i]);
                nodes[i].outDegree++;
            }
        }

        boolean[] visited = new boolean[n];
        Queue<Node> zeroOutDegreeNodes = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (nodes[i].outDegree == 0) {
                visited[i] = true;
                zeroOutDegreeNodes.add(nodes[i]);
            }
        }

        while (!zeroOutDegreeNodes.isEmpty()) {
            Node currentNode = zeroOutDegreeNodes.poll();

            for (Node node : currentNode.inComingEdges) {
                node.outDegree--;

                if (node.outDegree == 0 && !visited[node.val]) {
                    visited[node.val] = true;
                    zeroOutDegreeNodes.add(node);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}