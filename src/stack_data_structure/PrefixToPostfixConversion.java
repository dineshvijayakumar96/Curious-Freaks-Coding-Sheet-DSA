package stack_data_structure;

import java.util.Stack;

public class PrefixToPostfixConversion {

    public static String preToPost(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char character = s.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stack.push(String.valueOf(character));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String temp = operand1 + operand2 + character;
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "*-A/BC-/AKL";
        System.out.println("Output: " + preToPost(s));
    }
}
