package leetcode.challenge.leetcode_2683;

class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        if (derived.length == 1) {
            return true;
        }

        if (derived.length == 2) {
            return derived[0] == derived[1];
        }

        return canStartWith(derived, 0) || canStartWith(derived, 1);
    }

    public boolean canStartWith(int[] derived, int start) {

        int[] original = new int[derived.length];
        original[0] = start;
        for (int i = 1; i < derived.length - 1; i++) {
            if (derived[i - 1] == 0) {
                original[i] = original[i - 1];
            } else {
                original[i] = 1 - original[i - 1];
            }
        }

        return (original[derived.length - 1] ^ original[0]) == derived[derived.length - 1];
    }
}
