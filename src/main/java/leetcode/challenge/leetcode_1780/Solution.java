package leetcode.challenge.leetcode_1780;

class Solution {
    private static final int[] powersOfThree = new int[] {
        1,
        3,
        9,
        27,
        81,
        243,
        729,
        2187,
        6561,
        19683,
        59049,
        177147,
        531441,
        1594323,
        4782969,
        14348907,
        43046721,
        129140163,
        387420489,
        1162261467
    };
    private int maxLog;

    public boolean checkPowersOfThree(int n) {

        this.maxLog = (int) (Math.log(n) / Math.log(3));
        return isPowerOfThree(n);
    }

    protected final boolean isPowerOfThree(int sum) {

        if (sum == 0) return true;
        if (sum < 0) return false;
        if (maxLog < 0) return false;

        maxLog -= 1;

        return isPowerOfThree(sum - powersOfThree[maxLog + 1]) || isPowerOfThree(sum);
    }
}
