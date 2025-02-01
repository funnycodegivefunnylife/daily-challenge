package leetcode.challenge.leetcode_2337;

class Solution {
    public boolean canChange(String start, String target) {

        int index1 = 0;
        int index2 = 0;
        char[] startChars = start.toCharArray();
        char[] targetChars = target.toCharArray();

        while (index1 < startChars.length && index2 < targetChars.length) {

            char first = startChars[index1];
            char second = targetChars[index2];
            if (first == second) {
                // if first is L and the index
                if (first == 'L' && index1 < index2) {
                    return false;
                }

                if (first == 'R' && index1 > index2) {
                    return false;
                }

                index1++;
                index2++;
            } else if ((first == 'L' && second == 'R') || (second == 'L' && first == 'R')) {
                break;
            } else if (first == 'L' || first == 'R') {
                index2++;
            } else {
                index1++;
            }
        }

        StringBuilder startBuilder = new StringBuilder();
        StringBuilder targetBuilder = new StringBuilder();

        for (int i = 0; i < startChars.length; i++) {
            if (startChars[i] != '_') {
                startBuilder.append(startChars[i]);
            }
        }

        for (int i = 0; i < targetChars.length; i++) {
            if (targetChars[i] != '_') {
                targetBuilder.append(targetChars[i]);
            }
        }

        return startBuilder.toString().equals(targetBuilder.toString());
    }
}
