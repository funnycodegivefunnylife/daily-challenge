package leetcode.challenge.leetcode_2929;

class Solution {
    public long distributeCandies(int n, int limit) {
        
        long ways = 0L;

        for (int i = 0; i <= limit; i++) {
            ways += Math.max(
                Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1,
                0
            );
        }

        return ways;
    }
}