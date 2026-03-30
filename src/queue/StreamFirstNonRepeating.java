package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StreamFirstNonRepeating {

    public static String firstNonRepeating(String s) {
        StringBuilder result = new StringBuilder();
        int[] frequent = new int[26];
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            frequent[character - 'a']++;
            queue.add(character);
            while (!queue.isEmpty() && frequent[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aabc";
        System.out.println("Output: " + firstNonRepeating(s));
    }
}
