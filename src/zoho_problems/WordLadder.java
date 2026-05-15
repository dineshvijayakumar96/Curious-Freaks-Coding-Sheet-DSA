package zoho_problems;

import java.util.*;

public class WordLadder {

    public static class Node {
        String word;
        int length;
        public Node(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public static int shortestChain(String start, String target, String[] arr) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(arr));
        if (!wordSet.contains(target)) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 1));
        wordSet.remove(start);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currWord = current.word;
            int currLen = current.length;
            if (currWord.equals(target)) {
                return currLen;
            }
            char[] wordChars = currWord.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char originalChar = wordChars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    wordChars[i] = c;
                    String newWord = new String(wordChars);
                    if (wordSet.contains(newWord)) {
                        queue.add(new Node(newWord, currLen + 1));
                        wordSet.remove(newWord);
                    }
                }
                wordChars[i] = originalChar;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String start = "toon";
        String target = "plea";
        String[] arr = { "poon", "plee", "same", "poie", "plea", "plie", "poin" };
        System.out.println("Output: " + shortestChain(start, target, arr));
    }
}
