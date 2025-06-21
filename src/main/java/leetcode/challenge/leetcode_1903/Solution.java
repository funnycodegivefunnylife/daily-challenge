package leetcode.challenge.leetcode_1903;

class Solution {
    public String largestOddNumber(String num) {
        int indexOfLastOdd = -1;

        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                indexOfLastOdd = i;
                break;
            }
        }

        if (indexOfLastOdd == -1) {
            return "";
        } else {
            return num.substring(0, indexOfLastOdd + 1);
        }
    }
}

