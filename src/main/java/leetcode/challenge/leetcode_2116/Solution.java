package leetcode.challenge.leetcode_2116;

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        int balance = 0;

        for (int i = 0; i < n; ++i) {
            // If we have an unlocked character or a '(', we can potentially match a ')'
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                ++balance;
            } else if (balance > 0) {
                // We have a locked ')' and we have an earlier '(', so pair them
                --balance;
            } else {
                // Mismatched ')' which cannot be matched
                return false;
            }
        }


        balance = 0;

        for (int i = n - 1; i >= 0; --i) {
            // If we have an unlocked character or a ')', we can potentially match a '('
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                ++balance;
            } else if (balance > 0) {
                // We have a locked '(' and we have an earlier ')', so pair them
                --balance;
            } else {
                // Mismatched '(' which cannot be matched
                return false;
            }
        }

        return true;
    }
}