package stack_data_structure;

import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("^")) {
                int result = 0;
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                result = switch (s) {
                    case "+" -> leftOperand + rightOperand;
                    case "-" -> leftOperand - rightOperand;
                    case "*" -> leftOperand * rightOperand;
                    case "/" -> Math.floorDiv(leftOperand, rightOperand);
                    case "^" -> (int) Math.pow(leftOperand, rightOperand);
                    default -> result;
                };
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = { "2", "3", "^", "1", "+" };
        System.out.println("Output: " + evaluatePostfix(arr));
    }
}
