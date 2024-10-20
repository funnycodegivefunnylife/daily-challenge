package leetcode.challenge.leetcode_1106;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

enum Operator {
    NOT('!') {
        @Override
        boolean apply(List<Boolean> operands) {
            return !operands.get(0);
        }
    },
    OR('|') {
        @Override
        boolean apply(List<Boolean> operands) {
            boolean result = false;
            for (boolean operand : operands) {
                result |= operand;
            }
            return result;
        }
    },
    
    AND('&') {
        @Override
        boolean apply(List<Boolean> operands) {
            boolean result = true;
            for (boolean operand : operands) {
                result &= operand;
            }
            return result;
        }
    };
    
    private final char symbol;
    
    Operator(char symbol) {
        this.symbol = symbol;
    }
    abstract boolean apply(List<Boolean> operands);
    
    public static boolean isExpression(char c) {
        return Operator.NOT.symbol == c || Operator.OR.symbol == c || Operator.AND.symbol == c;
    }

    public static Optional<Operator> findByValue(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.symbol == symbol.charAt(0)) {
                return Optional.of(operator);
            }
        }
        return Optional.empty();
    }
}

public class BooleanEvaluatorStackImpl implements BooleanEvaluator {
    public static BooleanEvaluatorStackImpl INSTANCE = new BooleanEvaluatorStackImpl();
    @Override
    public boolean evaluate(String expression) {

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Operator.isExpression(c)) {
                stack.push(c);
            } else if (c == ')') {
                List<Boolean> operands = new java.util.ArrayList<>();
                while (stack.peek() != '(') {
                    char operand = stack.pop();
                    operands.add(operand == 't');
                }
                char operator = stack.pop();

                Optional<Operator> operatorOptional = Operator.findByValue(String.valueOf(operator));

                if (operatorOptional.isEmpty()) {
                    throw new IllegalArgumentException("Invalid operator: " + operator);
                }

                stack.push(operatorOptional.get().apply(operands) ? 't' : 'f');

            } else if (c == 't' || c == 'f') {
                stack.push(c);
            }
        }
        
        return stack.peek() == 't';
    }
}
