package leetcode.challenge.leetcode_2092;

import java.util.*;

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1; // Explicitly initialize rank
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

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
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        DisjointSet disjointSet = new DisjointSet(n);
        disjointSet.union(0, firstPerson);

        Map<Integer, List<int[]>> timeToMeetings = new TreeMap<>(); // Sorted automatically

        for (int[] meeting : meetings) {
            timeToMeetings.computeIfAbsent(meeting[2], k -> new ArrayList<>()).add(new int[]{meeting[0], meeting[1]});
        }

        for (int time : timeToMeetings.keySet()) {
            Set<Integer> peopleAtTime = new HashSet<>();

            // Step 1: Union all people meeting at this time
            for (int[] meeting : timeToMeetings.get(time)) {
                int start = meeting[0];
                int end = meeting[1];

                disjointSet.union(start, end);
                peopleAtTime.add(start);
                peopleAtTime.add(end);
            }

            Set<Integer> secretHolders = new HashSet<>();
            for (int person : peopleAtTime) {
                if (disjointSet.find(person) == disjointSet.find(0)) {
                    secretHolders.add(person);
                }
            }

            for (int person : peopleAtTime) {
                if (!secretHolders.contains(person)) {
                    disjointSet.parent[person] = person;
                }
            }
        }

        // Collect all people who know the secret
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (disjointSet.find(i) == disjointSet.find(0)) {
                result.add(i);
            }
        }

        return result;
    }
}
