package leetcode.challenge.leetcode_1106;

public interface BooleanEvaluator {
    BooleanEvaluator BOOLEAN_EVALUATOR = BooleanEvaluatorStackImpl.INSTANCE;
    boolean evaluate(String expression);
}
