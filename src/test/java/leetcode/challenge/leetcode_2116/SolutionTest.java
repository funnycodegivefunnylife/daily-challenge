package leetcode.challenge.leetcode_2116;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();


    @Test
    @DisplayName("Given string s: ))())), 010100, Output: true")
    public void test1() {
        String s = "))()))";
        String goal = "010100";
        boolean actual = solution.canBeValid(s, goal);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given string s: )), 01, Output: true")
    public void test2() {
        String s = "))";
        String goal = "01";
        boolean actual = solution.canBeValid(s, goal);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given string s: ((, 01, Output: true")
    public void test3() {
        String s = "))";
        String goal = "01";
        boolean actual = solution.canBeValid(s, goal);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    //s =
    //")("
    //locked =
    //"00"
    //Output
    //false
    //Expected
    //true

    @Test
    @DisplayName("Given string s: )((, 00, Output: true")
    public void test4() {
        String s = ")(";
        String goal = "00";
        boolean actual = solution.canBeValid(s, goal);
        boolean expected = true;

        assertEquals(expected, actual);
    }
}