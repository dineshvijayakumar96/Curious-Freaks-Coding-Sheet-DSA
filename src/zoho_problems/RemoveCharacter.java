package zoho_problems;

public class RemoveCharacter {

    public static String removeChars(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        boolean[] charsToRemove = new boolean[26];
        for (int i = 0; i < m; i++) {
            charsToRemove[str2.charAt(i) - 'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char currentChar = str1.charAt(i);
            if (!charsToRemove[currentChar - 'a']) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str1 = "occurrence";
        String str2 = "car";
        System.out.println("Output: " + removeChars(str1, str2));
    }
}
