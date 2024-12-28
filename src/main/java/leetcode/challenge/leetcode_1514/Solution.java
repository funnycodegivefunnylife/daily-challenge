package leetcode.challenge.leetcode_1514;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Node {
    int node;
    double prob;
    Node(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<Node>> graph = new java.util.HashMap<>();

        double[] prob = new double[n];

        for (int i = 0; i < n; i++) {
            prob[i] = 0;
        }

        prob[start_node] = 1;

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            double probability = succProb[i];
            List<Node> list = graph.getOrDefault(from, new java.util.ArrayList<>());
            list.add(new Node(to, probability));
            graph.put(from, list);

            list = graph.getOrDefault(to, new java.util.ArrayList<>());
            list.add(new Node(from, probability));
            graph.put(to, list);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Node(start_node, 1));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.node;
            double probability = current.prob;

            if (node == end_node) {
                return probability;
            }

            List<Node> adjacent = graph.get(node);
            if (adjacent == null) {
                continue;
            }

            for (Node next : adjacent) {
                int nextNode = next.node;
                double nextProb = next.prob;
                double newProb = probability * nextProb;
                if (newProb > prob[nextNode]) {
                    prob[nextNode] = newProb;
                    pq.add(new Node(nextNode, newProb));
                }
            }
        }

        return 0;
    }
}