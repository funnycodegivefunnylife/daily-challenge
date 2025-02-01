package leetcode.challenge.leetcode_2064;

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = quantities[0];

        for (int i = 1; i < quantities.length; i++) {
            high = Math.max(high, quantities[i]);
        }

        while (low < high) {
            int mid = (high - low) / 2 + low;

            if (canDistribute(quantities, n, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canDistribute(int[] quantities, int n, int nProduct) {
        int emptySlot = n;
        int nDistribute = 0;

        for (int i = 0; i < quantities.length && emptySlot > 0; i++) {
            int usedSlot = quantities[i] / nProduct + (quantities[i] % nProduct == 0 ? 0 : 1);
            emptySlot -= usedSlot;
            nDistribute++;
        }

        return nDistribute == quantities.length && emptySlot >= 0;
    }
}
