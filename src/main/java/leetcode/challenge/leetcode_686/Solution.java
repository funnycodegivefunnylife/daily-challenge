package leetcode.challenge.leetcode_686;

/**
 * LeetCode Problem 686
 *
 * TODO: Add problem description and link
 * Link: https://leetcode.com/problems/
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
class Solution {

    public int repeatedStringMatch(String a, String b) {
        int left = 0;
        int right = b.length() / a.length() + 2;
        StringBuilder sb = new StringBuilder();
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            sb.setLength(0);
            for (int i = 0; i < mid; i++) {
                sb.append(a);
            }

            if (sb.indexOf(b) != -1) {
                result = mid;
                right = mid - 1; // try to find a smaller match
            } else {
                left = mid + 1; // increase the number of repetitions
            }
        }

        return result;
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
