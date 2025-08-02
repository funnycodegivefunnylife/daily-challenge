package leetcode.challenge.leetcode_3170;

class Solution {
    public String clearStars(String s) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                chars[i] = ' ';

                // from i to previous indices, find the smallest letter and right most index
                int j = i - 1;
                char smallest = 'z';
                int rightMostIndex = -1;

                while (j >= 0 && chars[j] != '*') {
                    if ((rightMostIndex == -1 || chars[j] < smallest) && chars[j] != ' ') {
                        smallest = chars[j];
                        rightMostIndex = j;
                    }
                    j--;
                }

                // if rightMostIndex is not -1, replace the character at rightMostIndex with ' '
                if (rightMostIndex != -1) {
                    chars[rightMostIndex] = ' ';
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            if (c != ' ') {
                result.append(c);
            }
        }
        return result.toString();
    }
}
