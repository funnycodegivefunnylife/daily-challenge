package leetcode.challenge.leetcode_898;

import java.util.Arrays;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {

        int maxOrCanAchieve = findMaxOr(arr);
        int minOrCanAchieve = Arrays.stream(arr).min().getAsInt();

        // if the ith bit is 1, then there's at least one element in the array that has the ith bit as 0
        int zeroBitMask = 0;
        int oneBitMask = 0;

        for (int i = 0; i < arr.length; i++) {
            zeroBitMask |= ~arr[i];
            oneBitMask |= arr[i];
        }

        int count = 0;

        for (int i = minOrCanAchieve; i <= maxOrCanAchieve; i++) {

            boolean isPossible = checkIfPossible(i, zeroBitMask, oneBitMask);

            if (isPossible) {
                count++;
            }
        }

        return count;
    }

    private boolean checkIfPossible(int i, int zeroBitMask, int oneBitMask) {

        int nBit = calculateNBit(i);

        for (int j = 0; j < nBit; j++) {
            if ((i & (1 << j)) == 0) {
                if ((zeroBitMask & (1 << j)) == 0) {
                    return false;
                }
            } else {
                if ((oneBitMask & (1 << j)) == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public int calculateNBit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n >>= 1;
        }
        return count;
    }

    private int findMaxOr(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max |= arr[i];
        }
        return max;
    }
}