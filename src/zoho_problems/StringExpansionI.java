package zoho_problems;

public class StringExpansionI {

    public static String stringExpansionI(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentLetter = s.charAt(i);
            i++;
            int charCount = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                charCount = (charCount * 10) + s.charAt(i) - '0';
                i++;
            }
            for (int count = 0; count < charCount; count++) {
                result.append(currentLetter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "a1b10";
        System.out.println("Output: " + stringExpansionI(s));
    }
}
