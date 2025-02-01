package leetcode.challenge.leetcode_1497;

import java.util.Arrays;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int sum = Arrays.stream(arr).sum();
        if (sum % k != 0) {
            return false;
        }

        int[] arrModK = new int[k];
        for (int i : arr) {
            arrModK[(i % k + k) % k]++;
        }

        if (arrModK[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i < k / 2; i++) {
            if (arrModK[i] != arrModK[k - i]) {
                return false;
            }
        }

        return arrModK[0] % 2 == 0;
    }
}
