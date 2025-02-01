package leetcode.challenge.leetcode_2940;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Query {
    int x;
    int y;
    int originalIndex;

    public Query(int x, int y, int originalIndex) {
        this.x = x;
        this.y = y;
        this.originalIndex = originalIndex;
    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] result = new int[queries.length];

        Query[] queryArray = new Query[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x, y;
            if (queries[i][0] < queries[i][1]) {
                x = queries[i][0];
                y = queries[i][1];
            } else {
                x = queries[i][1];
                y = queries[i][0];
            }

            queryArray[i] = new Query(x, y, i);
        }

        Arrays.sort(queryArray, (a, b) -> b.y - a.y);

        Stack<Integer> stack = new Stack<>();

        int maxY = queryArray[0].y;

        for (int i = heights.length - 1; i > maxY; i--) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }

        int lastY = maxY;

        for (int i = 0; i < queryArray.length; i++) {
            Query query = queryArray[i];
            int x = query.x;
            int y = query.y;
            int originalIndex = query.originalIndex;

            int matchIndex = -1;

            for (int j = lastY; j > y; j--) {
                while (!stack.isEmpty() && heights[j] >= heights[stack.peek()]) {
                    stack.pop();
                }
                stack.push(j);
            }

            while (!stack.isEmpty() && heights[stack.peek()] <= heights[y]) {
                stack.pop();
            }

            if (x == y || heights[x] < heights[y]) {
                matchIndex = y;
            } else {

                if (!stack.isEmpty()) {
                    matchIndex = binarySearch(stack, x, heights);
                }
            }

            stack.push(y);
            lastY = y;
            result[originalIndex] = matchIndex;
        }

        return result;
    }

    private int binarySearch(List<Integer> stack, int x, int[] heights) {
        int left = 0;
        int right = stack.size() - 1;

        List<Integer> ascending = new ArrayList<>();

        for (int i = stack.size() - 1; i >= 0; i--) {
            ascending.add(stack.get(i));
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (heights[ascending.get(mid)] <= heights[x]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return heights[ascending.get(left)] > heights[x] ? ascending.get(left) : -1;
    }
}
