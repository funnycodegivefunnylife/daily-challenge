package leetcode.challenge.leetcode_2054;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxTwoEvents(int[][] events) {

        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int maximumBefore[] = new int[events.length];

        for (int i = 1; i < events.length; i++) {
            maximumBefore[i] = Math.max(maximumBefore[i - 1], events[i - 1][2]);
        }

        int max = 0;

        for (int i = 0; i < events.length; i++) {
            int start = events[i][0];
            int value = events[i][2];
            int low = 0;
            int high = events.length - 1;

            while (low < high) {
                int mid = (low + high) >> 1;

                if (events[mid][1] >= start) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            value += maximumBefore[low];

            max = Math.max(max, value);
        }

        return max;
    }
}

