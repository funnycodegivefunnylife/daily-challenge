package leetcode.challenge.leetode_1405;

import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) {
            pq.add(new int[] {0, a});
        }

        if (b > 0) {
            pq.add(new int[] {1, b});
        }

        if (c > 0) {
            pq.add(new int[] {2, c});
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            // if the last two characters are the same, we need to check if we can add the character
            if (isSameAsLastTwo(sb, first)) {
                if (pq.isEmpty()) {
                    break;
                }

                int[] second = pq.poll();
                sb.append((char) (second[0] + 'a'));
                second[1]--;
                if (second[1] > 0) {
                    pq.add(second);
                }

                pq.add(first);
            } else {
                sb.append((char) (first[0] + 'a'));
                first[1]--;
                if (first[1] > 0) {
                    pq.add(first);
                }
            }
        }

        return sb.toString();
    }

    private boolean isSameAsLastTwo(StringBuilder sb, int[] first) {
        if (sb.length() < 2) {
            return false;
        }

        char last = sb.charAt(sb.length() - 1);
        char secondLast = sb.charAt(sb.length() - 2);

        return last == first[0] + 'a' && secondLast == first[0] + 'a';
    }
}
