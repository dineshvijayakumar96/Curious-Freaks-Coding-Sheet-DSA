package stack_data_structure;

import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                result.append(character);
            } else if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()) {
                    char top = stack.peek();
                    if (precedence(character) < precedence(top) || precedence(character) == precedence(top) && character != '^') {
                        result.append(top);
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(character);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static int precedence(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    public static void main(String[] args) {
        String s = "a*(b+c)/d";
        System.out.println("Output: " + infixToPostfix(s));
    }
}
