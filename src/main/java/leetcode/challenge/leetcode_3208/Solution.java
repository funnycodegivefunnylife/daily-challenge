package leetcode.challenge.leetcode_3208;

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int rs = 0;
        int[] extendedCircle = new int[colors.length + k];

        for (int i = 0; i < colors.length; i++) {
            extendedCircle[i] = colors[i];
        }

        for (int i = 0; i < k; i++) {
            extendedCircle[colors.length + i] = colors[i];
        }

        int start = 0;
        int end = 1;

        while (end < extendedCircle.length) {
            if (extendedCircle[end] == extendedCircle[end - 1]) {
                start = end;
                end++;
                continue;
            }
            end++;

            if (end - start < k) {
                continue;
            }

            rs++;
        }

        return rs;
    }
}
