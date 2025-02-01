package leetcode.challenge.leetcode_2872;

import java.util.ArrayList;
import java.util.List;

class Node {
    int index;
    int value;
    List<Node> neighbors = new ArrayList<>();

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}

class Graph {
    Node[] nodes;
    int nNodes;
    int answer = 0;

    public Graph(int nNodes) {
        this.nNodes = nNodes;
        nodes = new Node[nNodes];
    }

    public void addNode(int index, int value) {
        nodes[index] = new Node(index, value);
    }

    public void addEdge(int from, int to) {
        nodes[from].addNeighbor(nodes[to]);
    }

    public int findConnectedComponents(int index, int k) {
        answer = 0;
        findConnectedComponents(index, -1, k);
        return answer;
    }

    public long findConnectedComponents(int index, int parentIndex, int k) {
        long sum = nodes[index].value;

        for (Node neighbor : nodes[index].neighbors) {
            if (neighbor.index == parentIndex) {
                continue;
            }

            sum += findConnectedComponents(neighbor.index, index, k);
        }

        if (sum % k == 0) {
            answer++;
        }

        return sum;
    }
}

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Graph graph = new Graph(n);

        for (int i = 0; i < n; i++) {
            graph.addNode(i, values[i]);
        }

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
            graph.addEdge(edge[1], edge[0]);
        }

        return graph.findConnectedComponents(0, k);
    }
}
