package leetcode.challenge.leetcode_1432;

class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);

        String maxNum = findMaxNum(numStr);
        String minNum = findMinNum(numStr);

        return Integer.parseInt(maxNum) - Integer.parseInt(minNum);
    }

    String findMaxNum(String numStr) {
        char firstChar = numStr.charAt(0);

        if (firstChar != '9') {
            return numStr.replace(firstChar, '9');
        } else {
            char replacementChar = '9';

            for (int i = 1; i < numStr.length(); i++) {
                if (numStr.charAt(i) < '9') {
                    return numStr.replace(numStr.charAt(i), replacementChar);
                }
            }
        }

        return numStr;
    }

    String findMinNum(String numStr) {
        char firstChar = numStr.charAt(0);

        if (firstChar != '1') {
            return numStr.replace(firstChar, '1');
        } else {

            for (int i = 1; i < numStr.length(); i++) {
                if (numStr.charAt(i) > '1') {
                    return numStr.replace(numStr.charAt(i), '0');
                }
            }
        }

        return numStr;
    }
}
