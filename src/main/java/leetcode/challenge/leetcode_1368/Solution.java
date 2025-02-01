package leetcode.challenge.leetcode_1368;

import java.util.Arrays;

class Solution {

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minCost(int[][] grid) {
        return 0;
    }

    int[] getDirection(int i) {
        return directions[i - 1];
    }


}
