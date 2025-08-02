package leetcode.challenge.leetcode_3015;

/**
 * LeetCode Problem 3015
 *
 * TODO: Add problem description and link
 * Link: https://leetcode.com/problems/
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
class Solution {

    public int[] countOfPairs(int n, int x, int y) {

        if (x > y) {
            return countOfPairs(n, y, x);
        }

        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int originalDistance = Math.abs(i - j);
                int applyXy = Math.abs(j - x) + Math.abs(i - y) + 1;
                result[Math.min(originalDistance, applyXy)] += 2;
            }
        }

        return result;
    }
}
