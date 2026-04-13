package zoho_problems;

public class StringExpansionII {

    public static String stringExpansion(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            result.append(c);
            result.append(count);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abbbbbbbbbb";
        System.out.println("Output: " + stringExpansion(s));
    }
}
