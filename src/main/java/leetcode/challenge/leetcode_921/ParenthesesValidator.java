package leetcode.challenge.leetcode_921;

public class ParenthesesValidator {

    public int minAddToMakeValid(String s) {
        int count = 0;

        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open == 0) {
                    count++;
                } else {
                    open--;
                }
            }
        }

        return count + open;
    }

    public static int calculate(String s) {
        ParenthesesValidator parenthesesValidator = new ParenthesesValidator();
        return parenthesesValidator.minAddToMakeValid(s);
    }
}
