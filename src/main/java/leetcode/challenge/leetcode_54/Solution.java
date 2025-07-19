package leetcode.challenge.leetcode_54;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        return traverse(matrix, 0, 0, rows - 1, cols - 1);
    }

    List<Integer> traverse(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        // traverse on the first row
        for (int j = startCol; j <= endCol; j++) {
            result.add(matrix[startRow][j]);
        }

        // traverse on the last col except the first element
        for (int i = startRow + 1; i <= endRow; i++) {
            result.add(matrix[i][endCol]);
        }

        // traverse on the last row except the last element
        if (startRow < endRow) {
            for (int j = endCol - 1; j >= startCol; j--) {
                result.add(matrix[endRow][j]);
            }
        }

        // traverse on the first col except the first and last elements
        if (startCol < endCol) {
            for (int i = endRow - 1; i > startRow; i--) {
                result.add(matrix[i][startCol]);
            }
        }

        // Recursive call for the inner matrix
        List<Integer> innerResult = traverse(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1);
        result.addAll(innerResult);

        return result;
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        fillMatrix(matrix, 0, 0, n - 1, n - 1, 1);
        return matrix;
    }

    public void fillMatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int num) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }

        // Fill the first row
        for (int j = startCol; j <= endCol; j++) {
            matrix[startRow][j] = num++;
        }

        // Fill the last column
        for (int i = startRow + 1; i <= endRow; i++) {
            matrix[i][endCol] = num++;
        }

        // Fill the last row if applicable
        if (startRow < endRow) {
            for (int j = endCol - 1; j >= startCol; j--) {
                matrix[endRow][j] = num++;
            }
        }

        // Fill the first column if applicable
        if (startCol < endCol) {
            for (int i = endRow - 1; i > startRow; i--) {
                matrix[i][startCol] = num++;
            }
        }

        // Recursive call for the inner matrix
        fillMatrix(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, num);
    }
}
