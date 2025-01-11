package leetcode.challenge.leetcode_1769;

class Solution {
    public int[] minOperations(String boxesInStr) {
        int[] boxes = new int[boxesInStr.length()];

        int[] result = new int[boxesInStr.length()];
        for (int i = 0; i < boxesInStr.length(); i++) {
            boxes[i] = boxesInStr.charAt(i) - '0';
        }

        for (int i = 0; i < boxes.length; i++) {
            int sum = 0;
            for (int j = 0; j < boxes.length; j++) {
                if (boxes[j] == 1) {
                    sum += Math.abs(i - j);
                }
            }
            result[i] = sum;
        }


        return result;
    }
}