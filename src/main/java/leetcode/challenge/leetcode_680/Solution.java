package leetcode.challenge.leetcode_680;

class Solution {
    public boolean validPalindrome(String s) {
        
        int skip = 0;

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (startChar == endChar) {
                start++;
                end--;
            } else {
                skip = 1;
                break;
            }
        }



        return skip == 0 || checkPalindrome(s, start) || checkPalindrome(s, end);
    }

    public boolean checkPalindrome(String s, int skipIndex) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (start == skipIndex) {
                start++;
            } else if (end == skipIndex) {
                end--;
            } else if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}