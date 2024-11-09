package leetcode.challenge.leetcode_3011;

class NumBit {
    int num;
    int setBits;
}

class Solution {

    public boolean canSortArray(int[] nums) {

        NumBit[] numBits = new NumBit[nums.length];

        for (int i = 0; i < nums.length; i++) {
            NumBit numBit = new NumBit();
            numBit.num = nums[i];
            numBit.setBits = calculateSetBits(nums[i]);
            numBits[i] = numBit;
        }
        boolean needSort = true;

        while (needSort) {
            needSort = false;
            for (int i = 0; i < numBits.length - 1; i++) {
                if (numBits[i].num > numBits[i + 1].num && canSwap(numBits[i], numBits[i + 1])) {
                    NumBit temp = numBits[i];
                    numBits[i] = numBits[i + 1];
                    numBits[i + 1] = temp;
                    needSort = true;
                } else if (numBits[i].num > numBits[i + 1].num) {
                    return false;
                }
            }
        }

        return true;
    }

    private int calculateSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public boolean canSwap(NumBit a, NumBit b) {
        return a.setBits == b.setBits;
    }
}