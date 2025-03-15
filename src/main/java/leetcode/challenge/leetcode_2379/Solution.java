package leetcode.challenge.leetcode_2379;

class Solution {
    public int minimumRecolors(String blocks, int k) {

        int minNumberOfWhite = 0;

        int currentNumberOfWhite = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currentNumberOfWhite++;
            }
        }

        minNumberOfWhite = currentNumberOfWhite;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                currentNumberOfWhite--;
            }

            if (blocks.charAt(i) == 'W') {
                currentNumberOfWhite++;
            }

            minNumberOfWhite = Math.min(minNumberOfWhite, currentNumberOfWhite);
        }


        return minNumberOfWhite;
    }
}