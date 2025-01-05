package leetcode.challenge.leetcode_983;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cumulativeCosts = new int[days.length];

        cumulativeCosts[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for (int i = 1; i < days.length; i++) {
            int cost1Day = costs[0] + cumulativeCosts[i - 1];
            int cost7day = calculateCostForPass(cumulativeCosts, days, costs[1], days[i] - 6);
            int cost30day = calculateCostForPass(cumulativeCosts, days, costs[2], days[i] - 29);

            cumulativeCosts[i] = Math.min(cost1Day, Math.min(cost7day, cost30day));
        }

        return cumulativeCosts[days.length - 1];
    }

    private int calculateCostForPass(int[] cumulativeCosts, int[] days, int passCost, int firstValidDay) {
        int firstIndex = findFirstGte(days, firstValidDay);
        if (firstIndex > 0) {
            return passCost + cumulativeCosts[firstIndex - 1];
        }
        return passCost;
    }


    public int findFirstGte(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (end + start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}