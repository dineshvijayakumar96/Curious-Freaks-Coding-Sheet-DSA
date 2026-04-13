package zoho_problems;

public class RemainingString {

    public static String printString(String s, char ch, int count) {
        if (count == 0) return s;
        StringBuilder result = new StringBuilder();
        int occurrence = 0;
        for (char c : s.toCharArray()) {
            if (occurrence == count) {
                result.append(c);
            }
            if (c == ch && occurrence < count) {
                occurrence++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Thisisdemostring";
        char ch = 'i';
        int count = 3;
        System.out.println("Output: " + printString(s, ch, count));
    }
}
