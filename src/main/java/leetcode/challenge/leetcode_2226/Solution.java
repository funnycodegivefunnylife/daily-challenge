package leetcode.challenge.leetcode_2226;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 0;
        int high = findMax(candies);


        while (low < high) {
            int mid = (high + low + 1) / 2;

            if (canGiveEqualCandies(candies, k, mid)) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }

    private int findMax(int[] nums) {
        int max = -1;

        for (int num: nums) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public boolean canGiveEqualCandies(int[] candies, long nChildren, int nCandies) {
        if (nCandies == 0) {
            return true;
        }
        long totalAllocated = 0;

        for (int candie: candies) {
            int nAllocated = candie / nCandies;
            totalAllocated += nAllocated;
            if (totalAllocated >= nChildren) {
                return true;
            }
        }

        return totalAllocated >= nChildren;
    }
}