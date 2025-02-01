package leetcode_1106;

import leetcode.challenge.leetcode_1106.BooleanEvaluator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBooleanEvaluator {

    private static final BooleanEvaluator evaluator = BooleanEvaluator.BOOLEAN_EVALUATOR;

    @Test
    @DisplayName("Test Case : !(f), expected = true")
    public void test1() {
        assert evaluator.evaluate("!(f)");
    }

    @Test
    @DisplayName("Test Case : !(t), expected = false")
    public void test2() {
        assert !evaluator.evaluate("!(t)");
    }

    @Test
    @DisplayName("Test Case : &(|(f)), expected = false")
    public void test3() {
        assert !evaluator.evaluate("&(|(f))");
    }

    @Test
    @DisplayName("Test Case : |(f,f,f,t), expected = true")
    public void test4() {
        assert evaluator.evaluate("|(f,f,f,t)");
    }
}
