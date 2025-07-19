package leetcode.challenge.leetcode_435;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int lastEnd = Integer.MIN_VALUE;

        int count = 0;

        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                lastEnd = interval[1];
            } else {
                count++;
                lastEnd = Math.min(lastEnd, interval[1]);
            }
        }

        return count;
    }
}
