package leetcode.challenge.leetcode_2594;

class Solution {
    public long repairCars(int[] ranks, int cars) {

        long low = 0;
        long high = findMaximumTimeCanRepair(ranks, cars);


        while (low < high) {
            long mid = (high + low) / 2;

            if (canRepairIn(ranks, cars, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long findMaximumTimeCanRepair(int[] ranks, int cars) {
        int min = ranks[0];
        for (int rank: ranks) {
            if (rank < min) {
                min = rank;
            }
        }

        return min * cars * cars;
    }


    public boolean canRepairIn(int[] ranks, int cars, long time) {

        int remainCars = cars;

        for (int rank: ranks) {
            int nCarRepaired = (int) Math.sqrt(time / rank);
            remainCars -= nCarRepaired;
        }

        return remainCars <= 0;
    }
}