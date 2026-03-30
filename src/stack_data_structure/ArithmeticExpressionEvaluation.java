package stack_data_structure;

import java.util.Stack;

public class ArithmeticExpressionEvaluation {

    public static int evaluateArithmeticExpression(String expression) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                operator.push(ch);
            } else if (Character.isDigit(ch)) {
                int digit = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    digit = digit * 10 + expression.charAt(i) - '0';
                    i++;
                }
                i--;
                operand.push(digit);
            } else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    int right = operand.pop();
                    int left = operand.pop();
                    char operation = operator.pop();
                    operand.push(calculateOperation(left, right, operation));
                }
                operator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
                    int right = operand.pop();
                    int left = operand.pop();
                    char operation = operator.pop();
                    operand.push(calculateOperation(left, right, operation));
                }
                operator.push(ch);
            }
        }
        return operand.peek();
    }

    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    private static int calculateOperation(int left, int right, char operation) {
        int result = 0;
        result = switch (operation) {
            case '+' -> left + right;
            case '-' -> left - right;
            case '*' -> left * right;
            case '/' -> left / right;
            default -> result;
        };
        return result;
    }

    public static void main(String[] args) {
        String expression = "((2+3)*(5/2))";
        System.out.println("Output: " + evaluateArithmeticExpression(expression));
    }
}
