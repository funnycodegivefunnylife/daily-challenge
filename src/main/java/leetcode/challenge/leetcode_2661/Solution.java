package leetcode.challenge.leetcode_2661;

import java.util.Map;

class Index {
    int x;
    int y;
}

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Index[] map = new Index[m * n];
        int[] rowFrequency = new int[m];
        int[] colFrequency = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Index index = new Index();
                index.x = i;
                index.y = j;
                map[mat[i][j]] = index;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            Index index = map[arr[i]];
            int row = index.x;
            int col = index.y;

            rowFrequency[row]++;
            colFrequency[col]++;
            if (rowFrequency[row] == n || colFrequency[col] == m) {
                return i;
            }
        }

        return -1;
    }

}