package leetcode.challenge.leetcode_1368;

class Solution {

    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        return 0;
    }

    int[] getDirection(int i) {
        return directions[i - 1];
    }
}
