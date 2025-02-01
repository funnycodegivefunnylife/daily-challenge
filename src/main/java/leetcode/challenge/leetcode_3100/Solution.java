package leetcode.challenge.leetcode_3100;

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {

        int nDrunk = 0;
        int nEmpty = 0;

        while (numBottles > 0) {
            nDrunk += numBottles;
            nEmpty += numBottles;

            numBottles = 0;

            if (nEmpty >= numExchange) {
                numBottles = 1;
                nEmpty -= numExchange;
                numExchange++;
            }
        }

        return nDrunk;
    }
}
