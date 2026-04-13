package zoho_problems;

import java.util.ArrayList;

public class PossibleWordsFromPhoneDigits {

    private static final String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return result;
        generateWords(arr, n, 0, new StringBuilder(), result);
        return result;
    }

    static void generateWords(int[] arr, int n, int index, StringBuilder currentWord, ArrayList<String> result) {
        if (index == n) {
            result.add(currentWord.toString());
            return;
        }
        int currentDigit = arr[index];
        String letters = keypad[currentDigit];
        if (letters.isEmpty()) {
            generateWords(arr, n, index + 1, currentWord, result);
            return;
        }
        for (int i = 0; i < letters.length(); i++) {
            currentWord.append(letters.charAt(i));
            generateWords(arr, n, index + 1, currentWord, result);
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3 };
        System.out.println("Output: " + possibleWords(arr));
    }
}
