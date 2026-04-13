package zoho_problems;

import java.util.Stack;

public class TheStringCalculator {

    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (operation == '+') stack.push(currentNumber);
                else if (operation == '-') stack.push(-currentNumber);
                else if (operation == '*') stack.push(stack.pop() * currentNumber);
                else if (operation == '/') stack.push(stack.pop() / currentNumber);

                operation = c;
                currentNumber = 0;
            }
        }

        int result = 0;
        for (int i : stack) result += i;
        return result;
    }

    public static void main(String[] args) {
        String s = "10+5*4-20/5";
        System.out.println("Output: " + calculate(s));
    }
}
