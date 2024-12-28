package leetcode.challenge.leetcode_2825;

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {

        int index1 = 0;
        int index2 = 0;

        while (index1 < str1.length() && index2 < str2.length()) {
            char first = str1.charAt(index1);
            char second = str2.charAt(index2);

            if (validPair(first, second)) {
                index2++;
            }

            index1++;
        }

        return index2 == str2.length();
    }

    public boolean validPair(char a, char b) {
        if (a - 'a' == b - 'a' - 1) {
            return true;
        }

        return a == 'z' && b == 'a' || a == b;
    }
}