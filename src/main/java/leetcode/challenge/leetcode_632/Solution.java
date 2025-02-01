package leetcode.challenge.leetcode_632;

import java.util.Comparator;
import java.util.List;

class NumberAndIndex {
    int number;
    int index;
    NumberAndIndex next;

    public NumberAndIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        NumberAndIndex[] roots = new NumberAndIndex[nums.size()];

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> num = nums.get(i);
            NumberAndIndex root = new NumberAndIndex(num.get(0), i);
            NumberAndIndex current = root;
            for (int j = 1; j < num.size(); j++) {
                current.next = new NumberAndIndex(num.get(j), i);
                current = current.next;
            }
            roots[i] = root;
        }

        java.util.PriorityQueue<NumberAndIndex> pq =
                new java.util.PriorityQueue<>(Comparator.comparingInt(a -> a.number));

        for (NumberAndIndex root : roots) {
            pq.add(root);
            maxVal = Math.max(maxVal, root.number);
        }

        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;

        int[] result = new int[2];
        while (true) {
            NumberAndIndex min = pq.poll();
            if (maxVal - min.number < minEnd - minStart) {
                minStart = min.number;
                minEnd = maxVal;
            }

            if (min.next == null) {
                break;
            }

            pq.add(min.next);
            maxVal = Math.max(maxVal, min.next.number);
        }

        result[0] = minStart;
        result[1] = minEnd;

        return result;
    }
}
