package leetcode.challenge.leetcode_1750;

class Solution {
    public int minimumLength(String s) {

        int firstIndex = 0;
        int lastIndex = s.length() - 1;

        while (firstIndex < lastIndex) {
            int firstChar = s.charAt(firstIndex);
            int lastChar = s.charAt(lastIndex);

            if (firstChar != lastChar) {
                break;
            }

            while (firstIndex < lastIndex && s.charAt(firstIndex) == firstChar) {
                firstIndex++;
            }

            while (firstIndex < lastIndex && s.charAt(lastIndex) == lastChar) {
                lastIndex--;
            }

        }

        return lastIndex - firstIndex + 1;
    }
}