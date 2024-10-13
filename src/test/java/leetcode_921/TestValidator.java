package leetcode_921;

import leetcode.challenge.leetcode_921.ParenthesesValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestValidator {

    //ParenthesesValidator

    //s = "())"
    @Test
    @DisplayName("Given string s = ()), when calculate is called, then it should return 1")
    public void test1() {
        String s = "())";
        int expected = 1;
        int result = ParenthesesValidator.calculate(s);
        assert expected == result;
    }


    @Test
    @DisplayName("Given string s = (((, when calculate is called, then it should return 3")
    public void test2() {
        String s = "(((";
        int expected = 3;
        int result = ParenthesesValidator.calculate(s);
        assert expected == result;
    }
}
