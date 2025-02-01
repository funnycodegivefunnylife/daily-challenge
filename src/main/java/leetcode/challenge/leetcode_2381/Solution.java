package leetcode.challenge.leetcode_2381;

class Solution {
    public String shiftingLetters(String s, int[][] shiftOperations) {

        char[] chars = s.toCharArray();

        int cumulativeShifts[] = new int[s.length() + 1];

        for (int shiftOperation[] : shiftOperations) {
            int start = shiftOperation[0];
            int end = shiftOperation[1];
            int shiftDirection = shiftOperation[2] == 1 ? 1 : -1;

            cumulativeShifts[start] += shiftDirection;
            cumulativeShifts[end + 1] -= shiftDirection;
        }

        for (int i = 1; i < cumulativeShifts.length; i++) {
            cumulativeShifts[i] += cumulativeShifts[i - 1];
        }

        for (int i = 0; i < s.length(); i++) {
            chars[i] = applyShift(chars[i], cumulativeShifts[i]);
        }

        return new String(chars);
    }

    public char applyShift(char c, int shift) {
        if (shift == 0) {
            return c;
        }

        if (shift > 0) {
            return applyShift(c, shift, true);
        } else {
            return applyShift(c, -shift, false);
        }
    }

    public char applyShift(char c, int shift, boolean shiftRight) {
        int shiftAmount = shift % 26;
        if (shiftRight) {
            return (char) ((c - 'a' + shiftAmount) % 26 + 'a');
        } else {
            return (char) ((c - 'a' - shiftAmount + 26) % 26 + 'a');
        }
    }
}
