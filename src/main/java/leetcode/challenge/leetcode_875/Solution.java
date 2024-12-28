package leetcode.challenge.leetcode_875;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int high = findMax(piles);
        int low = 0;

        while (low < high) {
            int mid = (high + low) / 2;

            if (canEatingWithSpeed(piles, h, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int findMax(int[] piles) {
        int max = -1;

        for (int pile: piles) {
            if (pile > max) {
                max = pile;
            }
        }

        return max;
    }


    public boolean canEatingWithSpeed(int piles[], int hour, int speed) {

        long minHour = 0;

        for (int pile: piles) {
            int requiredHour = (int) Math.ceil(pile * 1.0/ speed );
            minHour += requiredHour;
            if (minHour > hour) {
                return false;
            }
        }

        return minHour <= hour;
    }
}