package leetcode.challenge.leetcode_3160;

import java.util.Map;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] rs = new int[queries.length];

        Map<Integer, Integer> keyToColor = new java.util.HashMap<>();
        Map<Integer, Integer> colorToCount = new java.util.HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int key = queries[i][0];
            int color = queries[i][1];
            int currentColor = keyToColor.getOrDefault(key, -1);
            if (currentColor != -1) {
                colorToCount.put(currentColor, colorToCount.get(currentColor) - 1);
                if (colorToCount.get(currentColor) == 0) {
                    colorToCount.remove(currentColor);
                }
            }

            colorToCount.put(color, colorToCount.getOrDefault(color, 0) + 1);
            keyToColor.put(key, color);

            rs[i] = colorToCount.size();
        }

        return rs;
    }
}