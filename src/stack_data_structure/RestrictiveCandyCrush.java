package stack_data_structure;

import java.util.Stack;

public class RestrictiveCandyCrush {

    public static class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public static String reduced_String(String s, int k) {
        if (k == 1) return "";
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new Pair(c, 1));
            } else {
                if (stack.peek().character == c) {
                    stack.peek().count += 1;
                } else {
                    stack.push(new Pair(c, 1));
                }
            }
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.character);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "obiwjjruufcejzuvviojktiyhiaxulnqolpfcvkaiywhrrxezrybgyetmpulspmjzmcgbuhfhdvuccuydtolfpakoyscfylwjass";
        int k = 5;
        System.out.println("Output: " + reduced_String(s, k));
    }
}
