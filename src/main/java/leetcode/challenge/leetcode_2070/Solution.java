package leetcode.challenge.leetcode_2070;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        int[] maxBeautySoFar = new int[items.length + 1];

        for (int i = 1; i <= items.length; i++) {
            maxBeautySoFar[i] = Math.max(maxBeautySoFar[i - 1], items[i - 1][1]);
        }

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int index = findFirstGreaterThan(items, query);

            result[i] = maxBeautySoFar[index];
        }

        return result;
    }

    public int findFirstGreaterThan(int[][] items, int query) {

        int low = 0;
        int high = items.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (items[mid][0] > query) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
