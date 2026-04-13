package zoho_problems;

public class CountPalindromeWordsInASentence {

    public static int countPalindrome(String[] input) {
        if (input == null || input.length == 0) return 0;
        int count = 0;
        for (String word : input) {
            if (checkPalindrome(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkPalindrome(String word) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) != word.charAt((n - 1) - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input = { "Madam", "Arora", "teaches", "malayalam" };
        System.out.println("Output: " + countPalindrome(input));
    }
}
