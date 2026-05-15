package zoho_problems;

public class ReverseWords {

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == '.') i--;
            if (i < 0) break;
            int endOfWord = i;
            while (i >= 0 && s.charAt(i) != '.') i--;
            if (!result.isEmpty()) {
                result.append('.');
            }
            for (int j = i + 1; j <= endOfWord; j++) {
                result.append(s.charAt(j));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "..geeks..for.geeks.";
        System.out.println("Output: " + reverseWords(s));
    }
}
